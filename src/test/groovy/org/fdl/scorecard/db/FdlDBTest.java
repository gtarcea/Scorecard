package org.fdl.scorecard.db;

import org.hibernate.Session;
import org.junit.Test;

public class FdlDBTest
{
    @Test
    public void testEstablishConnection()
    {
        Session s = FdlDB.getSession();
        
    }
}
