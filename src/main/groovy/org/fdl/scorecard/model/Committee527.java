package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.Committee527")
@Table(name = "Committee527", schema = "fdl")
public class Committee527
{
    private int id;
    private int cycle;
    private int reportingQuarter;
    private int reportingYear;
    private String ein;
    private String name;
    private String affiliate;
    private String parentOrganization;
    private PacType pacType;
    private String fecId;
    private PoliticalParty party;
    private String primCode;
    private String primCodeSource;
    private FilingFrequency filingFrequency;
    private Committee527Type committeeType;
    private String committeeTypeSource;
    private CommitteeIdeology ideology;
    private String comments;   
    private String organizationState;

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

    @Column(name = "reportingQuarter")
    public int getReportingQuarter()
    {
        return reportingQuarter;
    }

    public void setReportingQuarter(int reportingQuarter)
    {
        this.reportingQuarter = reportingQuarter;
    }

    @Column(name = "reportingYear")
    public int getReportingYear()
    {
        return reportingYear;
    }

    public void setReportingYear(int reportingYear)
    {
        this.reportingYear = reportingYear;
    }

    @Column(name = "ein")
    public String getEin()
    {
        return ein;
    }

    public void setEin(String ein)
    {
        this.ein = ein;
    }

    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    @Column(name = "fecId")
    public String getFecId()
    {
        return fecId;
    }

    public void setFecId(String fecId)
    {
        this.fecId = fecId;
    }

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

    @Enumerated(EnumType.STRING)
    @Column(name = "filingFrequency")
    public FilingFrequency getFilingFrequency()
    {
        return filingFrequency;
    }

    public void setFilingFrequency(FilingFrequency filingFrequency)
    {
        this.filingFrequency = filingFrequency;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "committeeType")
    public Committee527Type getCommitteeType()
    {
        return committeeType;
    }

    public void setCommitteeType(Committee527Type committeeType)
    {
        this.committeeType = committeeType;
    }

    @Column(name = "committeeTypeSource")
    public String getCommitteeTypeSource()
    {
        return committeeTypeSource;
    }

    public void setCommitteeTypeSource(String committeeTypeSource)
    {
        this.committeeTypeSource = committeeTypeSource;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "ideology")
    public CommitteeIdeology getIdeology()
    {
        return ideology;
    }

    public void setIdeology(CommitteeIdeology ideology)
    {
        this.ideology = ideology;
    }

    @Column(name = "comments")
    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    @Column(name = "organizationState")
    public String getOrganizationState()
    {
        return organizationState;
    }

    public void setOrganizationState(String organizationState)
    {
        this.organizationState = organizationState;
    }
}
