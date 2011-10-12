package org.fdl.hibernate;

import org.hibernate.Session;
import org.ncibi.commons.closure.P1;

public interface SessionProcedure extends P1<Session>
{
    @Override
    public void apply(Session session);
}
