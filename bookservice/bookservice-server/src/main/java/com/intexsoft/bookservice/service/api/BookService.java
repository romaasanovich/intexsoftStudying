package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Book;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBookByID(Integer id);

    void add(Book book);

    void delete(Book book);

    @PreAuthorize("hasRole('ADMIN')")
    Book getByUUID(String UUID);

}
