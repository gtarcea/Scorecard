package org.fdl.db;

import java.util.List;

import org.hibernate.Session;

/**
 * A mock PersistenceSession for testing purposes. Returns null on all calls.
 * 
 * @author gtarcea
 *
 */
public class NullPersistenceSession implements PersistenceSession
{
    @Override
    public FluentQuery hqlQuery(String query)
    {
        return null;
    }

    @Override
    public FluentQuery hqlQuery(Session session, String query)
    {
        return null;
    }

    @Override
    public Session session()
    {
        return null;
    }

    @Override
    public FluentQuery sqlQuery(String query)
    {
        return null;
    }

    @Override
    public FluentQuery sqlQuery(Session session, String query)
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
