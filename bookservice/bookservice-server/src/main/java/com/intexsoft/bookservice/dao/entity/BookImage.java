package com.intexsoft.bookservice.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookImage")
public class BookImage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "imagePath")
    private String imagePath;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    public BookImage() {
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
