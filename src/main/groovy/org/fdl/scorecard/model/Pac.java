package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.Pac")
@Table(name = "Pac", schema = "fdl")
public class Pac
{
    private int id;  
    private int cycle;
    private String pacId;
    private String pacName;
    private String affiliate;
    private String parentOrganization;
    private String recipientId;
    private PacType pacType;
    private String fecId;
    private PoliticalParty party;
    private String primCode;
    private String primCodeSource;
    private boolean impactCCommittee; // Congressional Committee impacted
    private boolean foreignEntity;   
    private boolean active;

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

    @Column(name = "cycle")
    public int getCycle()
    {
        return cycle;
    }

    public void setCycle(int cycle)
    {
        this.cycle = cycle;
    }

    @Column(name = "pacId")
    public String getPacId()
    {
        return pacId;
    }

    public void setPacId(String pacId)
    {
        this.pacId = pacId;
    }

    @Column(name = "pacName")
    public String getPacName()
    {
        return pacName;
    }

    public void setPacName(String pacName)
    {
        this.pacName = pacName;
    }

    @Column(name = "affiliate")
    public String getAffiliate()
    {
        return affiliate;
    }

    public void setAffiliate(String affiliate)
    {
        this.affiliate = affiliate;
    }

    @Column(name = "parentOrganization")
    public String getParentOrganization()
    {
        return parentOrganization;
    }

    public void setParentOrganization(String parentOrganization)
    {
        this.parentOrganization = parentOrganization;
    }

    @Column(name = "recipientId")
    public String getRecipientId()
    {
        return recipientId;
    }

    public void setRecipientId(String recipientId)
    {
        this.recipientId = recipientId;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "pacType")
    public PacType getPacType()
    {
        return pacType;
    }

    public void setPacType(PacType pacType)
    {
        this.pacType = pacType;
    }

    @Column(name= "fecId")
    public String getFecId()
    {
        return fecId;
    }

    public void setFecId(String fecId)
    {
        this.fecId = fecId;
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

    @Column(name = "primCode")
    public String getPrimCode()
    {
        return primCode;
    }

    public void setPrimCode(String primCode)
    {
        this.primCode = primCode;
    }

    @Column(name = "primCodeSource")
    public String getPrimCodeSource()
    {
        return primCodeSource;
    }

    public void setPrimCodeSource(String primCodeSource)
    {
        this.primCodeSource = primCodeSource;
    }

    @Column(name = "impactCCommittee ")
    public boolean isImpactCCommittee ()
    {
        return impactCCommittee ;
    }

    public void setImpactCCommittee (boolean impactCCommittee )
    {
        this.impactCCommittee  = impactCCommittee ;
    }

    @Column(name = "foreignEntity")
    public boolean isForeignEntity()
    {
        return foreignEntity;
    }

    public void setForeignEntity(boolean foreignEntity)
    {
        this.foreignEntity = foreignEntity;
    }

    @Column(name = "active")
    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    @Override
    public String toString()
    {
        return "Pac [id=" + id + ", cycle=" + cycle + ", pacId=" + pacId + ", pacName=" + pacName
                + ", affiliate=" + affiliate + ", parentOrganization=" + parentOrganization
                + ", recipientId=" + recipientId + ", pacType=" + pacType + ", fecId=" + fecId + ", party="
                + party + ", primCode=" + primCode + ", primCodeSource=" + primCodeSource
                + ", impactCCommittee=" + impactCCommittee + ", foreignEntity=" + foreignEntity + ", active="
                + active + "]";
    }
}
