package com.intexsoft.bookservice.importentitiy.repository;

import com.intexsoft.bookservice.importentitiy.ImportAuthor;
import com.intexsoft.bookservice.importentitiy.ImportBook;
import com.intexsoft.bookservice.importentitiy.ImportPublisher;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name ="entities")
public class ImportEntityRepository {

    private List<ImportBook> books;
    private List<ImportAuthor> authors;
    private List<ImportPublisher> publishers;

    @XmlElementWrapper(name="books")
    @XmlElement(name="book")
    public List<ImportBook> getBooks() {
        return books;
    }

    public void setBooks(List<ImportBook> books) {
        this.books = books;
    }

    @XmlElementWrapper(name="authors")
    @XmlElement(name="author")
    public List<ImportAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<ImportAuthor> authors) {
        this.authors = authors;
    }

    @XmlElementWrapper(name="publishers")
    @XmlElement(name="publisher")
    public List<ImportPublisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<ImportPublisher> publishers) {
        this.publishers = publishers;
    }
}
