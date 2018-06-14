package com.intexsoft.bookservice.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookImage")
public class BookImage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "imageName")
    private String imageName;
    @Column(name = "typeImage")
    private String typeImage;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    public BookImage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }
}
