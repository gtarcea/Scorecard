package org.fdl.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.ncibi.commons.exception.ConstructorCalledError;

/**
 * This class provides factory methods to the various databases at NCIBI.
 * 
 * @author gtarcea
 * 
 */
public final class DB
{
    /**
     * Only static methods, the constructor should never be called.
     */
    private DB()
    {
        throw new ConstructorCalledError(this.getClass());
    }

    /**
     * A placeholder class to identify persistence units that have not been initialized.
     * 
     * @author gtarcea
     * 
     */
    private static class NullPersistenceSession implements PersistenceSession
    {
        @Override
        public FluentQuery hqlQuery(final String query)
        {
            return null;
        }

        @Override
        public FluentQuery hqlQuery(final Session session, final String query)
        {
            return null;
        }

        @Override
        public Session session()
        {
            return null;
        }

        @Override
        public FluentQuery sqlQuery(final String query)
        {
            return null;
        }
        
        @Override
        public FluentQuery sqlQuery(final Session session, final String query)
        {
            return null;
        }
        
        @Override
        public FluentQuery sqlQuery(final Session session, final String queryName, List<QueryProperty> qp)
        {
            return null;
        }
        
        @Override
        public FluentQuery hqlQuery(final Session session, final String queryName, List<QueryProperty> qp)
        {
            return null;
        }
        
        @Override
        public <T> void delete(final Session session, T what)
        {
            return;
        }
    }

    /**
     * Used for locking.
     */
    private static final Object lockObject = new Object();
    
    /**
     * An uninitialized session.
     */
    private static final NullPersistenceSession NULL_PERSISTENCE_SESSION = new NullPersistenceSession();

    /**
     * A list of all known persistence units.
     */
    private static Map<String, PersistenceSession> persistenceUnitsMap = loadPersistenceUnits();

    /**
     * Loads all the persistence unit names and sets them to NULL_PERSISTENCE_SESSION for later (lazy)
     * initialization.
     * 
     * @return The map of persistence units.
     */
    private static Map<String, PersistenceSession> loadPersistenceUnits()
    {
        final List<String> persistenceUnitNames = PersistenceUnits.getConfigured();
        final Map<String, PersistenceSession> punitMap = new HashMap<String, PersistenceSession>();

        for (final String punit : persistenceUnitNames)
        {
            punitMap.put(punit, NULL_PERSISTENCE_SESSION);
        }
        return punitMap;
    }

    /**
     * Retrieves a given persistence unit.
     * 
     * @param punit
     *            The name of the persistence unit to look up.
     * @return The persistence unit.
     */
    public static PersistenceUnit db(final String punit)
    {
        PersistenceSession p = persistenceUnitsMap.get(punit);

        if (p == null)
        {
            throw new IllegalArgumentException("Unknown Persistence Unit: " + punit);
        }
        else if (p == NULL_PERSISTENCE_SESSION)
        {
            synchronized (lockObject)
            {
                /*
                 * Make sure another thread hasn't initialized the persistence unit
                 * while we were waiting to acquire the lock.
                 */
                p = persistenceUnitsMap.get(punit);
                if (p == NULL_PERSISTENCE_SESSION)
                {
                    final PersistenceSession np = new PersistenceUnit(punit);
                    persistenceUnitsMap.put(punit, np);
                    p = np;
                }
            }
        }

        return (PersistenceUnit) p;
    }

}
