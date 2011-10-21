package org.fdl.db;

import org.hibernate.transform.ResultTransformer;

/**
 * An interface for creating fluent type queries. A Class can implement this interface to create an
 * fluent query such as:
 * <nl/>
 * <code>
 * sqlQuery("select * from Provenance").list()
 * </code>
 * 
 * @author gtarcea
 */
public interface FluentQuery
{
    /**
     * Sets the ResultTransformer for a query.
     * 
     * @param rt
     *            The ResultTransformer to use.
     * @return FluentQuery.
     */
    public FluentQuery to(ResultTransformer rt);

    /**
     * Binds a class (for SQL Queries) to a query.
     * 
     * @param <T>
     *            The class type.
     * @param cls
     *            The class to bind.
     * @return FluentQuery.
     */
    public <T> FluentQuery bind(Class<T> cls);

    /**
     * Sets a parameters value. A parameter in a query starts with a ':', for example <code> select * from Provenance where id = :id"</code>
     * 
     * @param param
     *            The parameter to set.
     * @param value
     *            The value to set it to.
     * @return FluentQuery.
     */
    public FluentQuery forParam(String param, Object value);

    /**
     * Runs the query returning a list of results. The query is wrapped in a transaction.
     * 
     * @param <T>
     *            The type of elements to return.
     * @return A list of results of type T.
     */
    public <T> T list();

    /**
     * Runs the query returning a single result. The query is wrapped in a transaction.
     * 
     * @param <T>
     *            The type of element to return.
     * @return A result of type T or null if nothing matches the query.
     */
    public <T> T single();

}
