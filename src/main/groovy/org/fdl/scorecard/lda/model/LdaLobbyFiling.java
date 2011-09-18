package org.fdl.scorecard.lda.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "sc.LdaLobbyFiling")
@Table(name = "LdaLobbyFiling", schema = "fdl")
public class LdaLobbyFiling
{
    private int id;
    private String filingId;
    private int year;
    private String received;
    private double amount;
    private String ltype;
    private String period;
    private LdaLobbyRegistrant registrant;
    private LdaLobbyClient client;
    private Set<LdaGovernmentEntity> governmentEntities;
    private Set<LdaForeignEntity> foreignEntities;
    private Set<LdaLobbyist> lobbyists;
    private Set<LdaLobbyIssue> issues;

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

    @Column(name = "filingId")
    public String getFilingId()
    {
        return filingId;
    }

    public void setFilingId(String filingId)
    {
        this.filingId = filingId;
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

    @Column(name = "received")
    public String getReceived()
    {
        return received;
    }

    public void setReceived(String received)
    {
        this.received = received;
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

    @Column(name = "ltype")
    public String getLtype()
    {
        return ltype;
    }

    public void setLtype(String ltype)
    {
        this.ltype = ltype;
    }

    @Column(name = "period")
    public String getPeriod()
    {
        return period;
    }

    public void setPeriod(String period)
    {
        this.period = period;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "registrantId", nullable = true)
    public LdaLobbyRegistrant getRegistrant()
    {
        return registrant;
    }

    public void setRegistrant(LdaLobbyRegistrant registrant)
    {
        this.registrant = registrant;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "clientId", nullable = true)
    public LdaLobbyClient getClient()
    {
        return client;
    }

    public void setClient(LdaLobbyClient client)
    {
        this.client = client;
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "LdaLobbyFiling2GovernmentEntity", schema = "fdl",
        joinColumns = { @JoinColumn (name = "lobbyFilingId", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "governmentEntityId") })
    public Set<LdaGovernmentEntity> getGovernmentEntities()
    {
        return governmentEntities;
    }

    public void setGovernmentEntities(Set<LdaGovernmentEntity> governmentEntities)
    {
        this.governmentEntities = governmentEntities;
    }
    
    public void addGovernmentEntity(LdaGovernmentEntity ge)
    {
        this.governmentEntities.add(ge);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "LdaLobbyFiling2ForeignEntity", schema = "fdl",
        joinColumns = { @JoinColumn (name = "lobbyFilingId", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "foreignEntityId") })
    public Set<LdaForeignEntity> getForeignEntities()
    {
        return foreignEntities;
    }

    public void setForeignEntities(Set<LdaForeignEntity> foreignEntities)
    {
        this.foreignEntities = foreignEntities;
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "LdaLobbyFiling2LdaLobbyist", schema = "fdl",
        joinColumns = { @JoinColumn (name = "lobbyFilingId", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "lobbyistId") })
    public Set<LdaLobbyist> getLobbyists()
    {
        return lobbyists;
    }

    public void setLobbyists(Set<LdaLobbyist> lobbyists)
    {
        this.lobbyists = lobbyists;
    }
    
    public void addLobbyist(LdaLobbyist lobbyist)
    {
        this.lobbyists.add(lobbyist);
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "LdaLobbyFiling2LdaLobbyIssue", schema = "fdl",
        joinColumns = { @JoinColumn (name = "lobbyFilingId") },
        inverseJoinColumns = { @JoinColumn (name = "lobbyIssueId") })
    public Set<LdaLobbyIssue> getIssues()
    {
        return issues;
    }

    public void setIssues(Set<LdaLobbyIssue> issues)
    {
        this.issues = issues;
    }
    
    public void addIssue(LdaLobbyIssue issue)
    {
        this.issues.add(issue);
    }

    @Override
    public String toString()
    {
        return "LdaLobbyFiling [id=" + id + ", filingId=" + filingId + ", year=" + year + ", received="
                + received + ", amount=" + amount + ", ltype=" + ltype + ", period=" + period
                + ", registrant=" + registrant + ", client=" + client + ", governmentEntities="
                + governmentEntities + ", foreignEntities=" + foreignEntities + ", lobbyists=" + lobbyists
                + ", issues=" + issues + "]";
    }
}
