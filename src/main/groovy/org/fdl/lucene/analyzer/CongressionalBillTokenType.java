package org.fdl.lucene.analyzer;

public enum CongressionalBillTokenType
{
    HOUSE("hr"), SENATE("s"), UNKNOWN("na");
    
    private final String token;
    
    private CongressionalBillTokenType(String token)
    {
        this.token = token;
    }
    
    @Override
    public String toString()
    {
        return this.token;
    }
}
