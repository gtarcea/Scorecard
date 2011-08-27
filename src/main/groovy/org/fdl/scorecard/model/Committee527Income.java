package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.Committee527Income")
@Table(name = "Committee527Income", schema = "fdl")
public class Committee527Income
{
    private int id;
    private int reportingQuarter;
    private int reportingYear;
    private String organizationName;    
    private double amount;

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

    @Column(name = "organizationName")
    public String getOrganizationName()
    {
        return organizationName;
    }

    public void setOrganizationName(String organizationName)
    {
        this.organizationName = organizationName;
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
}
