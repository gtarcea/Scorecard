package org.fdl.scorecard.lda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity(name = "sc.LdaLobbyIssue")
@Table(name = "LdaLobbyIssue", schema = "fdl")
@Indexed
public class LdaLobbyIssue
{
    private int id;
    private String code;   
    private String specificIssue;

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

    @Column(name = "code")
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @Column(name = "specificIssue")
    @Field(index = Index.TOKENIZED, store = Store.YES)
    public String getSpecificIssue()
    {
        return specificIssue;
    }

    public void setSpecificIssue(String specificIssue)
    {
        this.specificIssue = specificIssue;
    }
}
