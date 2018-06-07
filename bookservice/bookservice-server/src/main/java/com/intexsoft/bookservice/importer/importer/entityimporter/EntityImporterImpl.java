package com.intexsoft.bookservice.importer.importer.entityimporter;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.importer.entity.ImportAuthor;
import com.intexsoft.bookservice.importer.entity.ImportBook;
import com.intexsoft.bookservice.importer.entity.ImportPublisher;
import com.intexsoft.bookservice.importer.entity.repository.ImportEntityRepository;
import com.intexsoft.bookservice.service.api.AuthorService;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.service.api.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityImporterImpl implements EntityImporter {
    @Autowired
    private PublisherService publisherService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Override
    public void importEntities(ImportEntityRepository entityRepository) {
        List<ImportBook> books = entityRepository.getBooks();
        List<ImportAuthor> authors = entityRepository.getAuthors();
        List<ImportPublisher> publishers = entityRepository.getPublishers();
        importAuthorsToDB(authors);
        importPublishersToDB(publishers);
        importBooksToDB(books);
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
