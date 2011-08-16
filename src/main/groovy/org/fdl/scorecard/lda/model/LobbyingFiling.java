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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "sc.LobbyFiling")
@Table(name = "LobbyFiling", schema = "fdl")
public class LobbyingFiling
{
    private int id;
    private LobbyRegistrant registrant;
    private LobbyClient client;
    private Set<GovernmentEntity> governmentEntities;    
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

    public LobbyRegistrant getRegistrant()
    {
        return registrant;
    }

    public void setRegistrant(LobbyRegistrant registrant)
    {
        this.registrant = registrant;
    }

    public LobbyClient getClient()
    {
        return client;
    }

    public void setClient(LobbyClient client)
    {
        this.client = client;
    }

    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "LdaLobbyFiling2GovernmentEntity", schema = "fdl",
        joinColumns = { @JoinColumn (name = "lobbyFilingId", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "governmentEntityId") })
    public Set<GovernmentEntity> getGovernmentEntities()
    {
        return governmentEntities;
    }

    public void setGovernmentEntities(Set<GovernmentEntity> governmentEntities)
    {
        this.governmentEntities = governmentEntities;
    }
    
    public void addGovernmentEntity(GovernmentEntity ge)
    {
        this.governmentEntities.add(ge);
    }
    
    @OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable (name = "LdaLobbyFiling2LdaLobbyIssue", schema = "fdl",
        joinColumns = { @JoinColumn (name = "lobbyFilingId", nullable = false) },
        inverseJoinColumns = { @JoinColumn (name = "ldaLobbyIssueId") })
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
}
