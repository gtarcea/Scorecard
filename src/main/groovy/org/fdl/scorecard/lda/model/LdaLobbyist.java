package org.fdl.scorecard.lda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.LdaLobbyist")
@Table(name = "LdaLobbyist", schema = "fdl")
public class LdaLobbyist
{
    private int id;
    private String name;
    private int status;
    private int indicator;
    private String officialPosition;
    
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

    @Column(name = "status")
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    @Column(name = "indicator")
    public int getIndicator()
    {
        return indicator;
    }

    public void setIndicator(int indicator)
    {
        this.indicator = indicator;
    }

    @Column(name = "officialPosition")
    public String getOfficialPosition()
    {
        return officialPosition;
    }

    public void setOfficialPosition(String officialPosition)
    {
        this.officialPosition = officialPosition;
    }
}
