package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "SUBJECT")
public class Subject
{
    @Id
    @Column(name = "SUBJECTID")
    private long subjectId;

    @Column(name = "SUBTITLE")
    private String subTitle;

    @Column(name = "DURATIONINHOURS")
    private int durationInHours;

    @OneToMany(mappedBy="subjectId")
    private Set<Book> references;

    public long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(long subjectId)
    {
        this.subjectId = subjectId;
    }

    public String getSubTitle()
    {
        return subTitle;
    }

    public void setSubTitle(String subTitle)
    {
        this.subTitle = subTitle;
    }

    public int getDurationInHours()
    {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours)
    {
        this.durationInHours = durationInHours;
    }

    public Set<Book> getReferences()
    {
        return references;
    }

    public void setReferences(Set<Book> references)
    {
        this.references = references;
    }
}
