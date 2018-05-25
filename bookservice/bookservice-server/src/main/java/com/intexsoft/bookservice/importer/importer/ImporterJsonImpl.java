package com.intexsoft.bookservice.importer.importer;

import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.entity.Publisher;
import com.intexsoft.bookservice.importer.entity.ImportAuthor;
import com.intexsoft.bookservice.importer.entity.ImportBook;
import com.intexsoft.bookservice.importer.entity.ImportPublisher;
import com.intexsoft.bookservice.importer.entity.repository.ImportEntityRepository;
import com.intexsoft.bookservice.service.api.AuthorService;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.service.api.PublisherService;
import com.intexsoft.bookservice.utill.Converter;
import com.intexsoft.bookservice.utill.Reader;
import com.intexsoft.bookservice.utill.TypeImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImporterJsonImpl implements Importer {

    private final Logger errorLogger = LoggerFactory.getLogger("error");
    private final Logger infoLogger = LoggerFactory.getLogger("info");
    @Autowired
    PublisherService publisherService;
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;
    @Value("${jsonImport}")
    String jsonPath;

    @Override
    public TypeImport getType() {
        return TypeImport.json;
    }

    @Transactional
    @Override
    public void importToDb() {
        try {
            String jsonLine = "";
            try {
                Reader reader = new Reader();
                jsonLine = reader.readFile(jsonPath);
            } catch (IOException ex) {
                errorLogger.error("File not found: ", ex);
            }
            Converter converter = new Converter();
            ImportEntityRepository entityRep = converter.fromJsonToEntityRep(jsonLine);
            List<ImportBook> books = entityRep.getBooks();
            List<ImportAuthor> authors = entityRep.getAuthors();
            List<ImportPublisher> publishers = entityRep.getPublishers();
            infoLogger.info("Json is parse!!!");
            importAuthorsToDB(authors);
            infoLogger.info("Authors are import");
            importPublishersToDB(publishers);
            infoLogger.info("Publishers are import");
            importBooksToDB(books);
            infoLogger.info("Books are import");
        } catch (IOException ex) {
            errorLogger.error("Wrong Json Structure: ", ex);

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
            if (book.getAuthors().get(0) == null || book.getPublisher() == null) {
                break;
            }
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

