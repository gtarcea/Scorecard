package org.fdl.db;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.ncibi.commons.config.ProjectConfiguration;
import org.ncibi.commons.db.DBConfig;
import org.ncibi.commons.exception.ConstructorCalledError;

import com.google.common.collect.ImmutableMap;

/**
 * Utility class for creating an EntityManager.
 * 
 * @author gtarcea
 * 
 */
public final class EntityManagers
{
    /**
     * Not instantiable - utility class.
     */
    private EntityManagers()
    {
        throw new ConstructorCalledError(this.getClass());
    }

    /**
     * Creates a new EntityManager for the given persistenceUnit name.
     * 
     * @param persistenceUnit
     *            The persistenceUnit to create an EntityManager for.
     * @return A new EntityManager.
     */
    public static EntityManager newEntityManager(final String persistenceUnit)
    {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit);
        return emf.createEntityManager();
    }

    /**
     * Creates a new EntityManager for the given persistence unit using the
     * database url, username and password for the connection parameters.
     * 
     * @param persistenceUnit
     *            The persistenceUnit to create an EntityManager for.
     * @param url
     *            The database url to use.
     * @param username
     *            The database user to use.
     * @param password
     *            The password for the database user.
     * @return A new EntityManager.
     */
    public static EntityManager newEntityManager(final String persistenceUnit, final String url,
            final String username, final String password)
    {
        final Map<String, String> properties = ImmutableMap.of("hibernate.connection.url", url,
                "hibernate.connection.username", username, "hibernate.connection.password",
                password);
        return newEntityManager(persistenceUnit, properties);
    }

    /**
     * Creates a new EntityManager for the given persistence unit. Obtains the
     * database url, username and password from the DBConfig object.
     * 
     * @param persistenceUnit
     *            The persistenceUnit to create an EntityManager for.
     * @param dbConfig
     *            The DBConfig object used to obtain the database url, username
     *            and password.
     * @return A new EntityManager.
     */
    public static EntityManager newEntityManager(final String persistenceUnit,
            final DBConfig dbConfig)
    {
        return newEntityManager(persistenceUnit, dbConfig.getDatabaseUrl(), dbConfig
                .getDatabaseUsername(), dbConfig.getDatabasePassword());
    }

    /**
     * Creates a new EntityManager for the given persistence unit and configures
     * it with the given set of properties.
     * 
     * @param persistenceUnit
     *            The persistenceUnit to create an EntityManager for.
     * @param properties
     *            The properties used to configure the EntityManager.
     * @return A new EntityManager.
     */
    public static EntityManager newEntityManager(final String persistenceUnit,
            final Map<String, String> properties)
    {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnit,
                properties);
        return emf.createEntityManager();
    }

    /**
     * Creates a new EntityManager for the given persistence unit obtaining the
     * database url, username and password from the global ProjectConfiguration.
     * 
     * @param persistenceUnit
     *            The persistenceUnit to create an EntityManager for.
     * @return A new EntityManager.
     */
    public static EntityManager newEntityManagerFromProject(final String persistenceUnit)
    {
        return newEntityManager(persistenceUnit, new DBConfig(ProjectConfiguration.getProject()
                .getConfiguration(), persistenceUnit));
    }
}
