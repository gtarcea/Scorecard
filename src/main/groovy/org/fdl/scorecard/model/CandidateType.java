package org.fdl.scorecard.model;

public enum CandidateType
{
    INCUMBENT, CHALLENGER, OPEN_SEAT, UNKNOWN;
    
    public static CandidateType toCandidateType(String what)
    {
        if ("I".equals(what)) { return INCUMBENT; }
        else if ("C".equals(what)) { return CHALLENGER; }
        else if ("O".equals(what)) { return OPEN_SEAT; }
        else return UNKNOWN;
    }
}
