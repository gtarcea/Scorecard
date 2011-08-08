package org.fdl.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sc.LobbyIssue")
@Table(name = "LobbyIssue", schema = "fdl")
public class LobbyIssue
{
    private int id;
    private int osId;
    private String soprId;
    private String issueAreaCategory;
    private String issueAreaDescription;
    private String specificIssue;
    private int year;

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

    @Column(name = "osId")
    public int getOsId()
    {
        return osId;
    }

    public void setOsId(int osId)
    {
        this.osId = osId;
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

    @Column(name = "issueAreaCategory")
    public String getIssueAreaCategory()
    {
        return issueAreaCategory;
    }

    public void setIssueAreaCategory(String issueAreaCategory)
    {
        this.issueAreaCategory = issueAreaCategory;
    }

    @Column(name = "issueAreaDescription")
    public String getIssueAreaDescription()
    {
        return issueAreaDescription;
    }

    public void setIssueAreaDescription(String issueAreaDescription)
    {
        this.issueAreaDescription = issueAreaDescription;
    }

    @Column(name = "specificIssue")
    public String getSpecificIssue()
    {
        return specificIssue;
    }

    public void setSpecificIssue(String specificIssue)
    {
        this.specificIssue = specificIssue;
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
}
