package org.fdl.scorecard.db

import javax.persistence.Persistence;

class FdlDB
{
    private static def em
    private static def emf
    private static def session

    static
    {
        emf = Persistence.createEntityManagerFactory("metdb");
        em = emf.createEntityManager();
        session = em.delegate;
    }

    public static def getSession()
    {
        return session
    }
}