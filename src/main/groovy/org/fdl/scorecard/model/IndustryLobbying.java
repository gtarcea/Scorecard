package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.IndustryLobbying")
@Table(name = "IndustryLobbying", schema = "fdl")
public class IndustryLobbying
{
    private int id;
    private String parentCompany;
    private String clientName;
    private double totalAmount;
    private String crpCategory;
    private int year;

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

    @Column(name = "parentCompany")
    public String getParentCompany()
    {
        return parentCompany;
    }

    public void setParentCompany(String parentCompany)
    {
        this.parentCompany = parentCompany;
    }

    @Column(name = "clientName")
    public String getClientName()
    {
        return clientName;
    }

    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }

    @Column(name = "totalAmount")
    public double getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    @Column(name = "crpCategory")
    public String getCrpCategory()
    {
        return crpCategory;
    }

    public void setCrpCategory(String crpCategory)
    {
        this.crpCategory = crpCategory;
    }

    @Column(name = "year")
    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }
}
