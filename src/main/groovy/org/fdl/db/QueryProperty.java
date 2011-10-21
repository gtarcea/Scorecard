package org.fdl.db;

public class QueryProperty
{
	private int intValue ;
	private String strValue ;
	private String name ;
	private boolean isIntValue ;
	
	public QueryProperty(String name, String value)
	{
		isIntValue = false ;
		this.name = name ;
		strValue = value ;
	}
	
	public QueryProperty(String name, int value)
	{
		isIntValue = true ;
		this.name = name ;
		intValue = value ;
	}
	
	public String getName()
	{
		return name ;
	}
	
	public int getIntValue() // Should probably throw error if isIntValue == false
	{
		return intValue ;
	}
	
	public String getStrValue() // Should probably throw error if isIntValue == true
	{
		return strValue ;
	}
	
	public boolean isInt()
	{
		return isIntValue ;
	}
	
	public boolean isString()
	{
		return !isIntValue ;
	}

    @Override
    public String toString()
    {
        return "QueryProperty [intValue=" + intValue + ", strValue=" + strValue + ", name=" + name
                + ", isIntValue=" + isIntValue + "]";
    }
}
