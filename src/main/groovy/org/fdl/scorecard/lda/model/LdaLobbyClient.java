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

@Entity(name = "sc.LdaLobbyClient")
@Table(name = "LdaLobbyClient", schema = "fdl")
public class LdaLobbyClient
{
    private Integer id;
    private String name;
    private String description;
    private int clientId;
    private String status;
    private String contactName;
    private boolean stateOrLocalGovernment;
    private String country;
    private String ppbCountry;
    private String state;
    private String ppbState;
    private Set<LdaLobbyFiling> filings = new HashSet<LdaLobbyFiling>(0);

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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

    @Column(name = "description")
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Column(name = "clientId")
    public int getClientId()
    {
        return clientId;
    }

    public void setClientId(int clientId)
    {
        this.clientId = clientId;
    }

    @Column(name = "status")
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Column(name = "contactName")
    public String getContactName()
    {
        return contactName;
    }

    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    @Column(name = "stateOrLocalGovernment")
    public boolean isStateOrLocalGovernment()
    {
        return stateOrLocalGovernment;
    }

    public void setStateOrLocalGovernment(boolean stateOrLocalGovernment)
    {
        this.stateOrLocalGovernment = stateOrLocalGovernment;
    }

    @Column(name = "country")
    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        //System.out.println("country = " + country.length() + "/" + country);
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

    @Column(name = "state")
    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    @Column(name = "ppbState")
    public String getPpbState()
    {
        return ppbState;
    }

    public void setPpbState(String ppbState)
    {
        this.ppbState = ppbState;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            fetch = FetchType.LAZY, mappedBy = "client")
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
        return "LdaLobbyClient [id=" + id + ", name=" + name + ", description=" + description + ", clientId="
                + clientId + ", status=" + status + ", contactName=" + contactName
                + ", stateOrLocalGovernment=" + stateOrLocalGovernment + ", country=" + country
                + ", ppbCountry=" + ppbCountry + ", state=" + state + ", ppbState=" + ppbState + ", filings="
                + filings + "]";
    }
}
