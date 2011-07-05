package org.fdl.scorecard.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "sc.Bill")
@Table(name = "Bill", schema = "fdl")
public class Bill
{
    private int id;
    private Chamber chamber = Chamber.HOUSE;
    private String title;
    private Set<Representative> sponsors;
    private Set<Representative> cosponsors;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "chamber")
    public Chamber getChamber()
    {
        return chamber;
    }

    public void setChamber(Chamber chamber)
    {
        this.chamber = chamber;
    }

    @Column(name = "title")
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @OneToMany(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "Bill2Representative", schema = "fdl", joinColumns = {
        @JoinColumn(name = "billid", nullable = false)
    }, inverseJoinColumns = {
        @JoinColumn(name = "representaiveid")
    })
    public Set<Representative> getSponsors()
    {
        return sponsors;
    }

    public void setSponsors(Set<Representative> sponsors)
    {
        this.sponsors = sponsors;
    }

    @OneToMany(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "Bill2Representative", schema = "fdl", joinColumns = {
        @JoinColumn(name = "billid", nullable = false)
    }, inverseJoinColumns = {
        @JoinColumn(name = "representaiveid")
    })
    public Set<Representative> getCosponsors()
    {
        return cosponsors;
    }

    public void setCosponsors(Set<Representative> cosponsors)
    {
        this.cosponsors = cosponsors;
    }
}
