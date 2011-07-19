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

@Entity(name = "sc.PacContribution")
@Table(name = "PacContribution", schema = "fdl")
public class PacContribution
{
    private int id;
    private int cycle;
    private String fecTransactionId;
    private String pacId;
    private String donorPac;
    private String reportedName;
    private String reportedEmployer;
    private String primCode;
    private Date contribDate;
    private double amount;
    private String recipientId;
    private PoliticalParty party;
    private String committeeId;
    private RecipientType recipientType;
    private PoliticalParty recipientParty;
    private PacType recipientPacType;
    private String recipientPrimCode;
    private boolean amendedReport;
    private String reportType;
    private boolean generalElectionContrib;
    private ContributionType contributionType; 
    private String realCode;

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

    @Column(name = "donorPac")
    public String getDonorPac()
    {
        return donorPac;
    }

    public void setDonorPac(String donorPac)
    {
        this.donorPac = donorPac;
    }

    @Column(name = "reportedName")
    public String getReportedName()
    {
        return reportedName;
    }

    public void setReportedName(String reportedName)
    {
        this.reportedName = reportedName;
    }

    @Column(name = "reportedEmployer")
    public String getReportedEmployer()
    {
        return reportedEmployer;
    }

    public void setReportedEmployer(String reportedEmployer)
    {
        this.reportedEmployer = reportedEmployer;
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

    @Column(name = "contribDate")
    public Date getContribDate()
    {
        return contribDate;
    }

    public void setContribDate(Date contribDate)
    {
        this.contribDate = contribDate;
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
    @Column(name = "party")
    public PoliticalParty getParty()
    {
        return party;
    }

    public void setParty(PoliticalParty party)
    {
        this.party = party;
    }

    @Column(name = "committeeId")
    public String getCommitteeId()
    {
        return committeeId;
    }

    public void setCommitteeId(String committeeId)
    {
        this.committeeId = committeeId;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "recipientType")
    public RecipientType getRecipientType()
    {
        return recipientType;
    }

    public void setRecipientType(RecipientType recipientType)
    {
        this.recipientType = recipientType;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "recipientParty")
    public PoliticalParty getRecipientParty()
    {
        return recipientParty;
    }

    public void setRecipientParty(PoliticalParty recipientParty)
    {
        this.recipientParty = recipientParty;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "recipientPacType")
    public PacType getRecipientPacType()
    {
        return recipientPacType;
    }

    public void setRecipientPacType(PacType recipientPacType)
    {
        this.recipientPacType = recipientPacType;
    }

    @Column(name = "recipientPrimCode")
    public String getRecipientPrimCode()
    {
        return recipientPrimCode;
    }

    public void setRecipientPrimCode(String recipientPrimCode)
    {
        this.recipientPrimCode = recipientPrimCode;
    }

    @Column(name = "amendedReport")
    public boolean isAmendedReport()
    {
        return amendedReport;
    }

    public void setAmendedReport(boolean amendedReport)
    {
        this.amendedReport = amendedReport;
    }

    @Column(name = "reportType")
    public String getReportType()
    {
        return reportType;
    }

    public void setReportType(String reportType)
    {
        this.reportType = reportType;
    }

    @Column(name = "generalElectionContrib")
    public boolean isGeneralElectionContrib()
    {
        return generalElectionContrib;
    }

    public void setGeneralElectionContrib(boolean generalElectionContrib)
    {
        this.generalElectionContrib = generalElectionContrib;
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

    @Column(name = "realCode")
    public String getRealCode()
    {
        return realCode;
    }

    public void setRealCode(String realCode)
    {
        this.realCode = realCode;
    }
}
