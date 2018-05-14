package com.intexsoft.bookservice.entity;


import com.intexsoft.bookservice.entity.aentity.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book extends AbstractEntity {
    @Column(name = "name",length = 45)
    private String name;
    @Column(name = "description",length = 1500)
    private String description;
    @ManyToOne
    @JoinColumn(name = "publisherId")
    private Publisher publisher;
    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
            joinColumns = { @JoinColumn(name = "bookId") },
            inverseJoinColumns = { @JoinColumn(name = "authorId")})
    private List<Author> authors;

    public Book() {

    }

    public Book(Integer id, String name, String description, Publisher publisher, List<Author> authors) {
        super(id);
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
