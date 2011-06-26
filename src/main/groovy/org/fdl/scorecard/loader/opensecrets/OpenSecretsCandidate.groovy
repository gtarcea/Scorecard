package org.fdl.scorecard.loader.opensecrets;

import org.fdl.scorecard.model.CandidateType;
import org.fdl.scorecard.model.PoliticalParty;
import org.fdl.scorecard.model.Representative;

final class OpenSecretsCandidate
{
    Representative rep = new Representative();
    
    public void setFecId(String fecId)
    {
        callSetter("FecId", fecId)
    }
    
    public void setCid(String cid)
    {
        callSetter("Cid", cid)
    }
    
    public void setFirstLastName(String name)
    {
        
    }
    
    public void setParty(String party)
    {
        String p = removeBookends(party);
        rep.setParty(PoliticalParty.toPoliticalParty(p));
    }
    
    public void setDistrictIdRunFor(String districtId)
    {
        callSetter("DistrictIdRunFor", districtId)
    }
    
    public void setCurrentDistrictId(String districtId)
    {
        callSetter("CurrentDistrictId", districtId);
    }
    
    public void setCurrentlyRunning(String yorn)
    {
         rep.setCurrentlyRunning(isYes(yorn))   
    }
    
    public void setPreviouslyRan(String yorn)
    {
        rep.setPreviouslyRan(isYes(yorn));
    }
    
    public void setCandidateType(String candidateType)
    {
        rep.setCandidateType(CandidateType.toCandidateType(candidateType));
    }
    
    public void setNoPacs(String yorn)
    {
        rep.setNoPacs(isYes(yorn));
    }
    
    private void callSetter(setter, what)
    {
        rep."set${setter}"(removeBookends(what))
    }
    
    private String removeBookends(String what)
    {
        return what - "|" - "|"
    }
    
    private boolean isYes(String what)
    {
        String yes = removeBookends(what);
        if ("Y" == yes) { return true; }
        return false;
    }  
    
}