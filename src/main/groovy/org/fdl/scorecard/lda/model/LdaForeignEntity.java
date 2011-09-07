package org.fdl.scorecard.lda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.LdaForeignEntity")
@Table(name = "LdaForeignEntity", schema = "fdl")
public class LdaForeignEntity
{
    private int id;
    private String name;
    private String country;
    private String ppbCountry;
    private int foreignOwnershipPercentage;    
    private int status;

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

    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "country")
    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Column(name = "ppbCountry")
    public String getPpbCountry()
    {
        return ppbCountry;
    }

    public void setPpbCountry(String ppbCountry)
    {
        this.ppbCountry = ppbCountry;
    }

    @Column(name = "foreignOwnershipPercentage")
    public int getForeignOwnershipPercentage()
    {
        return foreignOwnershipPercentage;
    }

    public void setForeignOwnershipPercentage(int foreignOwnershipPercentage)
    {
        this.foreignOwnershipPercentage = foreignOwnershipPercentage;
    }

    @Column(name = "status")
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}
