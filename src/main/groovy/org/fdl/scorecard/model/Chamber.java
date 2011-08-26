package org.fdl.scorecard.model;

import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "sc.Chamber")
@Table(name = "Chamber", schema = "fdl")
public class Chamber
{
    private int id;
    private CongressionalChamber chamber;
    private Set<CongressionalCommittee> committees = new HashSet<CongressionalCommittee>(0);

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
    public CongressionalChamber getChamber()
    {
        return chamber;
    }

    public void setChamber(CongressionalChamber chamber)
    {
        this.chamber = chamber;
    }

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            fetch = FetchType.LAZY, mappedBy = "chamber")
    public Set<CongressionalCommittee> getCommittees()
    {
        return committees;
    }

    public void setCommittees(Set<CongressionalCommittee> committees)
    {
        this.committees = committees;
    }
}
