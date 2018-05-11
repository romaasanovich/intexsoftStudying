package com.intexsoft.bookservice.service;

import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional()
    @Override
    public List<Book> getAllBooks() {
        return  bookRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Book> getBookByID(Integer id) {
        return bookRepository.findById(id);
    }

}
