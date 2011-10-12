package org.fdl.hibernate;

import org.hibernate.Session;
import org.ncibi.commons.closure.F1;

/**
 * A hibernate session function that allows users to run
 * arbitrary queries against a hibernate session. These
 * functions will be wrapped in a transaction.
 * 
 * @author gtarcea
 *
 * @param <T>
 */
public interface SessionFunction<T> extends F1<T, Session>
{
    /**
     * The function to run.
     * @param session
     * @return
     */
    @Override
    public T apply(Session session);
}
