package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.importer.entity.ImportBook;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface BookService {

    @PreAuthorize("hasRole('ADMIN') OR hasRole('customer')")
    List<Book> getAllBooks();

    @PreAuthorize("hasRole('ADMIN') OR hasRole('customer')")
    Optional<Book> getBookByID(Integer id);

    @PreAuthorize("hasRole('ADMIN')")
    void add(Book book);

    @PreAuthorize("hasRole('ADMIN')")
    void delete(Book book);

    @PreAuthorize("hasRole('ADMIN')")
    Book getByUUID(String UUID);

}
