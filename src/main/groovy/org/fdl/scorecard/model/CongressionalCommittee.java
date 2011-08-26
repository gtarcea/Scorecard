package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "sc.CongressionalCommittee")
@Table(name = "CongressionalCommittee", schema = "fdl")
public class CongressionalCommittee
{
    private int id;
    private String name;   
    private Chamber chamber;

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

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "chamberId", nullable = false)
    public Chamber getChamber()
    {
        return chamber;
    }

    public void setChamber(Chamber chamber)
    {
        this.chamber = chamber;
    }
}
