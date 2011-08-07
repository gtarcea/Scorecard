package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.Lobbyist")
@Table(name = "Lobbyist", schema = "fdl")
public class Lobbyist
{
    private int id;
    private String soprId;
    private String lobbyistNameRaw;
    private String lobbyistNameStandardized;
    private String lobbyistId;
    private int year;
    private String previousGovernmentPosition;
    private String cid;   
    private boolean formerMemberOfCongress;

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

    @Column(name = "soprId")
    public String getSoprId()
    {
        return soprId;
    }

    public void setSoprId(String soprId)
    {
        this.soprId = soprId;
    }

    @Column(name = "lobbyistNameRaw")
    public String getLobbyistNameRaw()
    {
        return lobbyistNameRaw;
    }

    public void setLobbyistNameRaw(String lobbyistNameRaw)
    {
        this.lobbyistNameRaw = lobbyistNameRaw;
    }

    @Column(name = "lobbyistNameStandardized")
    public String getLobbyistNameStandardized()
    {
        return lobbyistNameStandardized;
    }

    public void setLobbyistNameStandardized(String lobbyistNameStandardized)
    {
        this.lobbyistNameStandardized = lobbyistNameStandardized;
    }

    @Column(name = "lobbyistId")
    public String getLobbyistId()
    {
        return lobbyistId;
    }

    public void setLobbyistId(String lobbyistId)
    {
        this.lobbyistId = lobbyistId;
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

    @Column(name = "previousGovernmentPosition")
    public String getPreviousGovernmentPosition()
    {
        return previousGovernmentPosition;
    }

    public void setPreviousGovernmentPosition(String previousGovernmentPosition)
    {
        this.previousGovernmentPosition = previousGovernmentPosition;
    }

    @Column(name = "cid")
    public String getCid()
    {
        return cid;
    }

    public void setCid(String cid)
    {
        this.cid = cid;
    }

    @Column(name = "formerMemberOfCongress")
    public boolean isFormerMemberOfCongress()
    {
        return formerMemberOfCongress;
    }

    public void setFormerMemberOfCongress(boolean formerMemberOfCongress)
    {
        this.formerMemberOfCongress = formerMemberOfCongress;
    }
}
