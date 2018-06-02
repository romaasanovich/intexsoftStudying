package com.intexsoft.bookservice.dao.entity;

import com.intexsoft.bookservice.dao.entity.aentity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review extends AbstractEntity {
    @Column(name = "review", length = 350)
    private String review;
    @Column(name = "rate")
    private Integer rate;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Review() {
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
