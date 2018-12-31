package org.arpit.java2blog.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "BOOK")
public class Book
{
    @Id
    @Column(name = "BOOKID")
    private long bookId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "VOLUME")
    private int volume;

    @Column(name = "PUBLISHDATE")
    @Temporal(TemporalType.DATE)
    private Date publishedDate;

    @ManyToOne
    @JoinColumn(name="SUBJECTID", nullable=false)
    private Subject subjectId;

    public long getBookId()
    {
        return bookId;
    }

    public void setBookId(long bookId)
    {
        this.bookId = bookId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getVolume()
    {
        return volume;
    }

    public void setVolume(int volume)
    {
        this.volume = volume;
    }

    public Date getPublishedDate()
    {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate)
    {
        this.publishedDate = publishedDate;
    }

    public Subject getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId)
    {
        this.subjectId = subjectId;
    }

    @Override
    public String toString()
    {
        return "Book: " + this.bookId + ", " + this.title + ", " + this.price;
    }
}