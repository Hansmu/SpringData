package com.git.spring.data.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
//Named queries - Statically defined queries with a pre-defined, unchangable query string.
//Defined on the entity.
@NamedQueries({ //Name - lead with the entity name, then use dot, followed by the repository method name it should correspond with.
        @NamedQuery(name="Book.queryAll", query="SELECT b FROM Book b"),
        @NamedQuery(name="Book.queryForAllWithGreaterPageCount", query="SELECT b FROM Book b WHERE b.pageCount > ?1"),
        @NamedQuery(name="Book.queryAllWithTitle", query="SELECT b FROM Book b WHERE b.title= :title")
}) /** Call for these named queries as you would call for a regular one. Off of the repository. **/
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PUBLISH_DATE")
    private Date publishDate;

    @Column(name = "PAGE_COUNT")
    private int pageCount;

    @Column(name = "PRICE")
    private BigDecimal price;

    public Book() {

    }

    public Book(String title, Date publishDate, int pageCount, BigDecimal price) {
        this.title = title;
        this.publishDate = publishDate;
        this.pageCount = pageCount;
        this.price = price;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", pageCount=" + pageCount +
                ", price=" + price +
                '}';
    }
}
