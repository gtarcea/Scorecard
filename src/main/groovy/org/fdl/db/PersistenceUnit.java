package org.fdl.db;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.ncibi.commons.config.ProjectConfiguration;
import org.ncibi.commons.db.DBConfig;
import org.fdl.hibernate.SessionFunction;
import org.fdl.hibernate.SessionProcedure;
import org.fdl.hibernate.Sessions;

import com.google.common.collect.ImmutableMap;
//import com.google.inject.Inject;

/**
 * Implements basic access to a JPA persistence unit by exposing the Hibernate Session. The
 * Hibernate Session is used because of the added functionality available in a Session as opposed to
 * a JPA entityManager.
 * 
 * @author gtarcea
 */
public final class PersistenceUnit implements PersistenceSession
{
    /**
     * The database JPA entity manager.
     */
    private final EntityManager entityManager;

    /**
     * The database Hibernate session factory. This is used to get new Hibernate Sessions.
     */
    private final SessionFactory sessionFactory;

    /**
     * Constructor - Creates the database connection. Sets the database url, username, and user
     * password from the project configuration file. The properties must match the persistence unit
     * name. See DBConfig in commons for details.
     * 
     * @param persistenceUnit
     *            The JPA persistence unit to load.
     */
    public PersistenceUnit(final String persistenceUnit)
    {
        final Map<String, String> properties = getUnitProperties(persistenceUnit);
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit,
                    properties);
        entityManager = emf.createEntityManager();
        final Session session = (Session) entityManager.getDelegate();
        sessionFactory = session.getSessionFactory();
    }

    /**
     * Constructor. Gets all the needed resources from the configured EntityManager.
     * 
     * @param entityManager
     *            The EntityManager to inject.
     */
    //@Inject
    public PersistenceUnit(final EntityManager entityManager)
    {
        this.entityManager = entityManager;
        final Session session = (Session) entityManager.getDelegate();
        this.sessionFactory = session.getSessionFactory();
    }

    /**
     * Creates a map for the createEntityManagerFactory() method containing the database url,
     * username, and password.
     * 
     * @param persistenceUnit
     *            The persistence unit used to find the names in the properties file.
     * @return A map containing the url, username and password with Hibernate properies as the keys.
     */
    private static Map<String, String> getUnitProperties(final String persistenceUnit)
    {
        final DBConfig dbConfig = new DBConfig(
                    ProjectConfiguration.getProject().getConfiguration(), persistenceUnit);
        final Map<String, String> properties = ImmutableMap.of("hibernate.connection.url", dbConfig
                    .getDatabaseUrl(), "hibernate.connection.username", dbConfig
                    .getDatabaseUsername(), "hibernate.connection.password", dbConfig
                    .getDatabasePassword());
        return properties;
    }

    /**
     * Returns a new Hibernate session for the persistence unit .
     * 
     * @return The Hibernate session.
     */
    @Override
    public Session session()
    {
        return sessionFactory.openSession();
    }

    /**
     * An internal class implementing the FluentQuery interface.
     * 
     * @author gtarcea
     */
    private static abstract class FluentQueryImpl implements FluentQuery
    {
        /**
         * The session to use, or if null a new session will be allocated.
         */
        private final Session session;

        /**
         * autoClose the session only when a session is not passed in.
         */
        private final boolean autoClose;

        /**
         * The hibernate query object that is used to set the states in our FluentQuery.
         */
        private Query query;

        /**
         * We need to keep track of whether or not this is a SQL Query.
         */
        private boolean isSql;

        /**
         * Creates a new Session. Used when no session is specified in the fluent interface.
         * 
         * @return A new session.
         */
        public abstract Session newSession();

        /**
         * Constructor. Creates a new session.
         * 
         * @param query
         *            The query to execute.
         * @param isSql
         *            When true the query is an SQL query.
         */
        public FluentQueryImpl(final String query, final boolean isSql)
        {
            session = newSession();
            autoClose = true;
            setupQueryType(query, isSql);
        }

        /**
         * Constructor. Uses the given session rather than creating a new one.
         * 
         * @param session
         *            The session to use.
         * @param query
         *            The query to execute.
         * @param isSql
         *            When true the query is an SQL query.
         */
        public FluentQueryImpl(final Session session, final String query, final boolean isSql)
        {
            this.session = session;
            autoClose = false;
            setupQueryType(query, isSql);
        }
        
        public FluentQueryImpl(final Session session, final Query query)
        {
            this.session = session;
            this.query = query;
            this.autoClose = true;
        }

        /**
         * Setup the query type and perform common initialization for the constructors.
         * 
         * @param query
         *            The query to execute.
         * @param isSql
         *            When true this is an SQL type query.
         */
        private void setupQueryType(final String query, final boolean isSql)
        {
            this.isSql = isSql;
            if (isSql)
            {
                this.query = session.createSQLQuery(query);
            }
            else
            {
                this.query = session.createQuery(query);
            }
        }

        /**
         * Binds the class for a SQL Query.
         */
        @Override
        public <T> FluentQuery bind(final Class<T> cls)
        {
            if (!isSql)
            {
                throw new IllegalStateException("FluentQuery isn't a SQL Query.");
            }

            final SQLQuery sqlQuery = (SQLQuery) query;
            sqlQuery.addEntity(cls);
            return this;
        }

        /**
         * Sets a named parameter to the specified.
         */
        @Override
        public FluentQuery forParam(final String param, final Object value)
        {
            query.setParameter(param, value);
            return this;
        }

        /**
         * Used when result is a non-persistent object that needs to be transformed.
         */
        @Override
        public FluentQuery to(final ResultTransformer rt)
        {
            query.setResultTransformer(rt);
            return this;
        }

        /**
         * Returns a list of results.
         */
        @SuppressWarnings("unchecked")
        @Override
        public <T> T list()
        {
            final SessionFunction<T> sfunc = new SessionFunction<T>()
            {
                @Override
                public T apply(final Session session)
                {
                    return (T) query.list();
                }
            };

            return Sessions.withSession(session, autoClose, sfunc);
        }

        /**
         * Returns a single result.
         */
        @SuppressWarnings("unchecked")
        @Override
        public <T> T single()
        {
            final SessionFunction<T> sfunc = new SessionFunction<T>()
            {
                @Override
                public T apply(final Session session)
                {
                    return (T) query.setMaxResults(1).uniqueResult();
                }
            };

            return Sessions.withSession(session, autoClose, sfunc);
        }

    }

    /**
     * Creates a HQL type FluentQuery. A new session is implicitly created (and closed afterwards).
     * 
     * @param query
     *            The HQL to run.
     * @return A FluentQuery for HQL.
     */
    @Override
    public FluentQuery hqlQuery(final String query)
    {
        final FluentQuery fluentQuery = new FluentQueryImpl(query, false)
        {
            @Override
            public Session newSession()
            {
                return session();
            }
        };

        return fluentQuery;
    }

    /**
     * Creates a HQL type FluentQuery. Uses the given session.
     * 
     * @param session
     *            The session to use.
     * @param query
     *            The HQL to run.
     * @return A FluentQuery for HQL.
     */
    @Override
    public FluentQuery hqlQuery(final Session session, final String query)
    {
        final FluentQuery fluentQuery = new FluentQueryImpl(session, query, false)
        {
            @Override
            public Session newSession()
            {
                return session;
            }
        };

        return fluentQuery;
    }
    
    @Override
    public FluentQuery hqlQuery(final Session session, final String queryName, List<QueryProperty> qpList)
    {
        Query q = session.getNamedQuery(queryName);
        if (qpList != null)
        {
            for (QueryProperty qp : qpList)
            {
                if (qp.isInt())
                {
                    q = q.setInteger(qp.getName(), qp.getIntValue());
                }
                else
                {
                    q = q.setString(qp.getName(), qp.getStrValue());
                }
            }
        }
        
        final FluentQuery fluentQuery = new FluentQueryImpl(session, q)
        {
            @Override
            public Session newSession()
            {
                return session;
            }
        };

        return fluentQuery;
    }
    
    /**
     * Creates a SQL type FluentQuery. A new session is implicitly created (and closed afterwards).
     * 
     * @param query
     *            The SQL to run.
     * @return A FluentQuery for SQL.
     */
    @Override
    public FluentQuery sqlQuery(final String query)
    {
        final FluentQuery fluentQuery = new FluentQueryImpl(query, true)
        {
            @Override
            public Session newSession()
            {
                return session();
            }
        };

        return fluentQuery;
    }

    /**
     * Creates a SQL type FluentQuery. Uses the given session.
     * 
     * @param session
     *            The session to use.
     * @param query
     *            The SQL to run.
     * @return A FluentQuery for SQL.
     */
    
    @Override
    public FluentQuery sqlQuery(final Session session,  final String queryName, List<QueryProperty> qpList)
    {
        Query q = session.getNamedQuery(queryName);
        if (qpList != null)
        {
            for (QueryProperty qp : qpList)
            {
                if (qp.isInt())
                {
                    q = q.setInteger(qp.getName(), qp.getIntValue());
                }
                else
                {
                    q = q.setString(qp.getName(), qp.getStrValue());
                }
            }
        }
        
        final FluentQuery fluentQuery = new FluentQueryImpl(session, q.getQueryString(), true)
        {
            @Override
            public Session newSession()
            {
                return session;
            }
        };

        return fluentQuery;
    }
    
    
    @Override
    public FluentQuery sqlQuery(final Session session, final String query)
    {
        final FluentQuery fluentQuery = new FluentQueryImpl(session, query, true)
        {
            @Override
            public Session newSession()
            {
                return session;
            }
        };

        return fluentQuery;
    }

    @Override
    public <T> void delete(final Session session, final T entry)
    {
        Sessions.withSession(session, new SessionProcedure()
        {
            @Override
            public void apply(Session session)
            {
                session.delete(entry);
            }
        });
    }
}
