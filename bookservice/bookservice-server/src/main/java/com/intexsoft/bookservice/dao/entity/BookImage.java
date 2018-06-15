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
    @Column(name = "imageType")
    private String imageType;
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

    public String getImageType() {
        return imageType;
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType.name();
    }
}
