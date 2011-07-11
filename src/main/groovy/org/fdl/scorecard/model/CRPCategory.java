package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.CRPCategory")
@Table(name = "CRPCategory", schema = "fdl")
public class CRPCategory
{
    private int id;
    private String categoryCode;
    private String categoryName;
    private String categoryOrder;
    private String industry;
    private String sector;   
    private String sectorLong;

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

    @Column(name = "categoryCode")
    public String getCategoryCode()
    {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode)
    {
        this.categoryCode = categoryCode;
    }

    @Column(name = "categoryName")
    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    @Column(name = "categoryOrder")
    public String getCategoryOrder()
    {
        return categoryOrder;
    }

    public void setCategoryOrder(String categoryOrder)
    {
        this.categoryOrder = categoryOrder;
    }

    @Column(name = "industry")
    public String getIndustry()
    {
        return industry;
    }

    public void setIndustry(String industry)
    {
        this.industry = industry;
    }

    @Column(name = "sector")
    public String getSector()
    {
        return sector;
    }

    public void setSector(String sector)
    {
        this.sector = sector;
    }

    @Column(name = "sectorLong")
    public String getSectorLong()
    {
        return sectorLong;
    }

    public void setSectorLong(String sectorLong)
    {
        this.sectorLong = sectorLong;
    }

    @Override
    public String toString()
    {
        return "CRPCategory [id=" + id + ", categoryCode=" + categoryCode + ", categoryName=" + categoryName
                + ", categoryOrder=" + categoryOrder + ", industry=" + industry + ", sector=" + sector
                + ", sectorLong=" + sectorLong + "]";
    }
}
