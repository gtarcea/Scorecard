package org.fdl.db;

import java.util.List;

import org.hibernate.Session;

/**
 * This interface provides methods for performing JPA/Hibernate calls in the context of a session.
 * It provides a FluentInterface to make calls easier and the implementations must wrap the calls in
 * transactions.
 * 
 * @author gtarcea
 * 
 */
public interface PersistenceSession
{
    /**
     * Returns a new Hibernate session.
     * 
     * @return The Hibernate session.
     */
    public Session session();

    /**
     * Creates a HQL type FluentQuery. A new session is implicitly created (and closed afterwards).
     * 
     * @param query
     *            The HQL to run.
     * @return A FluentQuery for HQL.
     */
    public FluentQuery hqlQuery(final String query);
    
    public FluentQuery hqlQuery(final Session session, final String queryName, List<QueryProperty> qp);

    /**
     * Creates a HQL type FluentQuery. Uses the given session.
     * 
     * @param session
     *            The session to use.
     * @param query
     *            The HQL to run.
     * @return A FluentQuery for HQL.
     */
    public FluentQuery hqlQuery(final Session session, final String query);

    /**
     * Creates a SQL type FluentQuery. A new session is implicitly created (and closed afterwards).
     * 
     * @param query
     *            The SQL to run.
     * @return A FluentQuery for SQL.
     */
    public FluentQuery sqlQuery(final String query);

    /**
     * Creates a SQL type FluentQuery. Uses the given session.
     * 
     * @param session
     *            The session to use.
     * @param query
     *            The SQL to run.
     * @return A FluentQuery for SQL.
     */
    public FluentQuery sqlQuery(final Session session, final String query);
    
    public FluentQuery sqlQuery(final Session session, final String queryName, List<QueryProperty> qp);
    
    public <T> void delete(final Session session, T entry);
}
