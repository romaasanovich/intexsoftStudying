package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.repository.BookRepository;
import com.intexsoft.bookservice.utill.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional()
    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }

    @Transactional
    @Override
    public Optional<Book> getBookByID(Integer id) {
        return bookRepository.findById(id);
    }

    @Transactional
    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }


    @Transactional
    @Override
    public void delete(Book book) {
        bookRepository.delete(book);

    }

    @Transactional
    @Override
    public void exportToDB(ArrayList<Book> books) {
        for (Book book : books) {
            if (bookRepository.findByUUID(book.getUuid()) == null) {
                bookRepository.create(book.getUuid(), book.getName(), book.getDescription(), Converter.fromDateToString(book.getPublishDate()), book.getPublisher().getId().toString(), book.getPrice().toString());
            }
            bookRepository.update(book.getUuid(), book.getName(), book.getDescription(), Converter.fromDateToString(book.getPublishDate()), book.getPublisher().getId().toString(), book.getPrice().toString(), book.getId().toString());
        }
    }
}
