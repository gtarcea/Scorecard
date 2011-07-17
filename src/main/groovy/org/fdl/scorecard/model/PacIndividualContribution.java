package org.fdl.scorecard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.PacIndividualContribution")
@Table(name = "PacIndividualContribution", schema = "fdl")
public class PacIndividualContribution
{
    private int id;
    private int cycle;
    private String fecTransactionId;
    private String pacId;
    private String cid;
    private double amount;
    private Date contribDate;
    private String primCode;
    private ContributionType contributionType;
    private boolean directContribution;    
    private String fecCandidateId;

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

    @Column(name = "fecTransactionId")
    public String getFecTransactionId()
    {
        return fecTransactionId;
    }

    public void setFecTransactionId(String fecTransactionId)
    {
        this.fecTransactionId = fecTransactionId;
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

    @Column(name = "cid")
    public String getCid()
    {
        return cid;
    }

    public void setCid(String cid)
    {
        this.cid = cid;
    }

    @Column(name = "amount")
    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    @Column(name = "contribDate")
    public Date getContribDate()
    {
        return contribDate;
    }

    public void setContribDate(Date contribDate)
    {
        this.contribDate = contribDate;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "contributionType")
    public ContributionType getContributionType()
    {
        return contributionType;
    }

    public void setContributionType(ContributionType contributionType)
    {
        this.contributionType = contributionType;
    }

    @Column(name = "directContribution")
    public boolean isDirectContribution()
    {
        return directContribution;
    }

    public void setDirectContribution(boolean directContribution)
    {
        this.directContribution = directContribution;
    }

    @Column(name = "fecCandidateId")
    public String getFecCandidateId()
    {
        return fecCandidateId;
    }

    public void setFecCandidateId(String fecCandidateId)
    {
        this.fecCandidateId = fecCandidateId;
    }
}
