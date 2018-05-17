package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.AuthorService;
import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.api.PublisherService;
import com.intexsoft.bookservice.entity.Author;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.importentitiy.ImportBook;
import com.intexsoft.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Optional<Book> getBookByID(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);

    }

    @Override
    public Book getByUUID(String UUID) {
        return bookRepository.findUUID(UUID);
    }

    @Override
    public void importToDB(List<ImportBook> books) {

        for (ImportBook importBook : books) {
            String uuid = importBook.getUuid();
            Book book = bookRepository.findUUID(uuid);
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
            bookRepository.save(book);
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
