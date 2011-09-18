package org.fdl.scorecard.lda.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "sc.LdaLobbyRegistrant")
@Table(name = "LdaLobbyRegistrant", schema = "fdl")
public class LdaLobbyRegistrant
{
    private int id;
    private int registrantId;
    private String name;
    private String description;
    private String address;
    private String country;  
    private String ppbCountry;
    private Set<LdaLobbyFiling> filings = new HashSet<LdaLobbyFiling>(0);

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

    @Column(name = "registrantId")
    public int getRegistrantId()
    {
        return registrantId;
    }

    public void setRegistrantId(int registrantId)
    {
        this.registrantId = registrantId;
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

    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Column(name = "address")
    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
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

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            fetch = FetchType.LAZY, mappedBy = "registrant")
    public Set<LdaLobbyFiling> getFilings()
    {
        return filings;
    }

    public void setFilings(Set<LdaLobbyFiling> filings)
    {
        this.filings = filings;
    }
    
    public void addFiling(LdaLobbyFiling filing)
    {
        this.filings.add(filing);
    }

    @Override
    public String toString()
    {
        return "LdaLobbyRegistrant [id=" + id + ", registrantId=" + registrantId + ", name=" + name
                + ", description=" + description + ", address=" + address + ", country=" + country
                + ", ppbCountry=" + ppbCountry + ", filings=" + filings + "]";
    }
}
