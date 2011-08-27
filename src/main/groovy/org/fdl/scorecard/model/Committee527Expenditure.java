package org.fdl.scorecard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.Committee527Expenditure")
@Table(name = "Committee527Expenditure", schema = "fdl")
public class Committee527Expenditure
{
    private int id;
    private int reportingQuarter;
    private int reportingYear;
    private String orgName;
    private String ein;
    private String recipient;
    private String recipientCrp;
    private double amount;
    private Date expenditureDate;
    private String expenditureCode;
    private String expenditurePurpose;
    

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

    @Column(name = "orgName")
    public String getOrgName()
    {
        return orgName;
    }

    public void setOrgName(String orgName)
    {
        this.orgName = orgName;
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

    @Column(name = "recipient")
    public String getRecipient()
    {
        return recipient;
    }

    public void setRecipient(String recipient)
    {
        this.recipient = recipient;
    }

    @Column(name = "recipientCrp")
    public String getRecipientCrp()
    {
        return recipientCrp;
    }

    public void setRecipientCrp(String recipientCrp)
    {
        this.recipientCrp = recipientCrp;
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

    @Column(name = "expenditureDate")
    public Date getExpenditureDate()
    {
        return expenditureDate;
    }

    public void setExpenditureDate(Date expenditureDate)
    {
        this.expenditureDate = expenditureDate;
    }

    @Column(name = "expenditureCode")
    public String getExpenditureCode()
    {
        return expenditureCode;
    }

    public void setExpenditureCode(String expenditureCode)
    {
        this.expenditureCode = expenditureCode;
    }

    @Column(name = "expenditurePurpose")
    public String getExpenditurePurpose()
    {
        return expenditurePurpose;
    }

    public void setExpenditurePurpose(String expenditurePurpose)
    {
        this.expenditurePurpose = expenditurePurpose;
    }
}
