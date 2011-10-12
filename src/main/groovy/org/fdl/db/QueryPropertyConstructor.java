package org.fdl.db;

import java.util.ArrayList;
import java.util.List;

public class QueryPropertyConstructor
{
    List<QueryProperty> queryProperties = new ArrayList<QueryProperty>();
    
    public QueryPropertyConstructor addProperty(String name, int value)
    {
        queryProperties.add(new QueryProperty(name, value));
        return this;
    }
    
    public QueryPropertyConstructor addProperty(String name, String value)
    {
        queryProperties.add(new QueryProperty(name, value));
        return this;
    }
    
    public List<QueryProperty> make()
    {
        return this.queryProperties;
    }
    
    public static QueryPropertyConstructor create()
    {
        return new QueryPropertyConstructor();
    }
}
