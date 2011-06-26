package org.fdl.scorecard.model;

public enum PoliticalParty
{
    DEMOCRAT, REPUBLICAN, INDEPENDENT, LIBERTARIAN, THIRD_PARTY, UNKNOWN;
    
    public static PoliticalParty toPoliticalParty(String what)
    {
        if ("D".equals(what)) { return DEMOCRAT; }
        else if ("R".equals(what)) { return REPUBLICAN; }
        else if ("I".equals(what)) { return INDEPENDENT; }
        else if ("L".equals(what)) { return LIBERTARIAN; }
        else if ("3".equals(what)) { return THIRD_PARTY; }
        else return UNKNOWN;
    }
}
