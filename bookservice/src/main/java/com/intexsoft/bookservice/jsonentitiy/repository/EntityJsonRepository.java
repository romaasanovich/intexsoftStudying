package com.intexsoft.bookservice.jsonentitiy.repository;

import com.intexsoft.bookservice.jsonentitiy.AuthorJson;
import com.intexsoft.bookservice.jsonentitiy.BookJson;
import com.intexsoft.bookservice.jsonentitiy.PublisherJson;

import java.util.List;

public class EntityJsonRepository {
    private List<BookJson> books;
    private List<AuthorJson> authors;
    private List<PublisherJson> publishers;

    public List<BookJson> getBooks() {
        return books;
    }

    public void setBooks(List<BookJson> books) {
        this.books = books;
    }

    public List<AuthorJson> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorJson> authors) {
        this.authors = authors;
    }

    public List<PublisherJson> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<PublisherJson> publishers) {
        this.publishers = publishers;
    }
}
