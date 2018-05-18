package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.AuthorService;
import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.api.ImportService;
import com.intexsoft.bookservice.api.PublisherService;
import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.entity.Publisher;
import com.intexsoft.bookservice.importentitiy.ImportAuthor;
import com.intexsoft.bookservice.importentitiy.ImportBook;
import com.intexsoft.bookservice.importentitiy.ImportPublisher;
import com.intexsoft.bookservice.importentitiy.repository.ImportEntityRepository;
import com.intexsoft.bookservice.utill.Converter;
import com.intexsoft.bookservice.utill.PropertyWorker;
import com.intexsoft.bookservice.utill.Reader;
import com.intexsoft.bookservice.utill.TypeImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportServiceXmlImpl implements ImportService {

    @Autowired
    PublisherService publisherService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;
    private static final String XML_PATH_PROP = "xmlImport";
    private final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Override
    public TypeImport getType() {
        return TypeImport.xml;
    }

    @Transactional
    @Override
    public void importToDb() {
        try {
            PropertyWorker pW = new PropertyWorker();
            Reader reader = new Reader();
            Converter converter = new Converter();
            ImportEntityRepository entityRep = converter.fromXmlToEntityRep(reader.getFile(pW.getProperty(XML_PATH_PROP)));
            List<ImportBook> books = entityRep.getBooks();
            List<ImportAuthor> authors = entityRep.getAuthors();
            List<ImportPublisher> publishers = entityRep.getPublishers();
            importPublishersToDB(publishers);
            importAuthorsToDB(authors);
            importBooksToDB(books);
        } catch (Exception ex) {
            logger.error("Error: ", ex);
        }
    }

    private void importPublishersToDB(List<ImportPublisher> publishers) {
        for (ImportPublisher importPublisher : publishers) {
            Publisher publisher = publisherService.getByUUID(importPublisher.getUuid());
            if (publisher == null) {
                publisher = new Publisher();
            }
            publisher.setName(importPublisher.getName());
            publisher.setUuid(importPublisher.getUuid());
            publisherService.add(publisher);
        }
    }

    private void importAuthorsToDB(List<ImportAuthor> authors) {
        for (ImportAuthor importAuthor : authors) {
            Author author = authorService.getByUUID(importAuthor.getUuid());
            if (author == null) {
                author = new Author();
            }
            author.setName(importAuthor.getName());
            author.setBio(importAuthor.getBio());
            author.setBirthDay(importAuthor.getBirthDay());
            author.setUuid(importAuthor.getUuid());
            authorService.add(author);
        }
    }


    private void importBooksToDB(List<ImportBook> books) {
        for (ImportBook importBook : books) {
            String uuid = importBook.getUuid();
            Book book = bookService.getByUUID(uuid);
            if (book == null) {
                book = new Book();
            }
            book.setName(importBook.getName());
            book.setUuid(importBook.getUuid());
            book.setDescription(importBook.getDescription());
            book.setPrice(importBook.getPrice());
            book.setPublishDate(importBook.getPublishDate());
            book.setPublisher(publisherService.getByUUID(importBook.getPublisherUUID()));
            book.setAuthors(getAuthors(importBook.getAuthorsUUID()));
            bookService.add(book);
        }
    }

    private List<Author> getAuthors(List<String> uuids) {
        List<Author> authors = new ArrayList<>();
        for (String uuid : uuids) {
            authors.add(authorService.getByUUID(uuid));
        }
        return authors;
    }

}

