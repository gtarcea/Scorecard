package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.Representative")
@Table(name = "Representative", schema = "fdl")
public class Representative
{
    private int id;
    private String fecId;
    private String cid;
    private String lastName;
    private String firstName;
    private PoliticalParty party;
    private String districtIdRunFor;
    private String currentDistrictId;
    private boolean currentlyRunning;
    private boolean previouslyRan;
    private CandidateType candidateType;
    private boolean noPacs;
    private Committee committee;
    
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    @Column(name = "fecId")
    public String getFecId()
    {
        return fecId;
    }

    public void setFecId(String fecId)
    {
        this.fecId = fecId;
    }

    @Column(name = "cid")
    public String getCid()
    {
        return cid;
    }

    public void setCid(String cid)
    {
        this.cid = cid;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "party")
    public PoliticalParty getParty()
    {
        return party;
    }
    
    public void setParty(PoliticalParty party)
    {
        this.party = party;
    }

    @Column(name = "districtIdRunFor")
    public String getDistrictIdRunFor()
    {
        return districtIdRunFor;
    }

    public void setDistrictIdRunFor(String districtIdRunFor)
    {
        this.districtIdRunFor = districtIdRunFor;
    }

    @Column(name = "currentDistrictId")
    public String getCurrentDistrictId()
    {
        return currentDistrictId;
    }

    public void setCurrentDistrictId(String currentDistrictId)
    {
        this.currentDistrictId = currentDistrictId;
    }

    @Column(name = "currentlyRunning")
    public boolean isCurrentlyRunning()
    {
        return currentlyRunning;
    }

    public void setCurrentlyRunning(boolean currentlyRunning)
    {
        this.currentlyRunning = currentlyRunning;
    }

    @Column(name = "previouslyRan")
    public boolean isPreviouslyRan()
    {
        return previouslyRan;
    }

    public void setPreviouslyRan(boolean previouslyRan)
    {
        this.previouslyRan = previouslyRan;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "candidateType")
    public CandidateType getCandidateType()
    {
        return candidateType;
    }

    public void setCandidateType(CandidateType candidateType)
    {
        this.candidateType = candidateType;
    }

    public boolean isNoPacs()
    {
        return noPacs;
    }

    public void setNoPacs(boolean noPacs)
    {
        this.noPacs = noPacs;
    }

    @Column(name = "lastName")
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Column(name = "firstName")
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "committee")
    public Committee getCommittee()
    {
        return committee;
    }

    public void setCommittee(Committee committee)
    {
        this.committee = committee;
    }

    @Override
    public String toString()
    {
        return "Representative [id=" + id + ", fecId=" + fecId + ", cid=" + cid + ", lastName=" + lastName
                + ", firstName=" + firstName + ", party=" + party + ", districtIdRunFor=" + districtIdRunFor
                + ", currentDistrictId=" + currentDistrictId + ", currentlyRunning=" + currentlyRunning
                + ", previouslyRan=" + previouslyRan + ", candidateType=" + candidateType + ", noPacs="
                + noPacs + ", committee=" + committee + "]";
    }
}
