package org.fdl.scorecard.db

import javax.persistence.Persistence

import org.hibernate.Session

class FdlDB
{
    private static def em
    private static def emf
    private static def session

    static
    {
        emf = Persistence.createEntityManagerFactory("scorecard");
        em = emf.createEntityManager();
        session = em.delegate;
    }

    public static Session getSession()
    {
        return session
    }
}