package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookService {

    Page<Book> getBooks(Pageable pageable);

    Optional<Book> getBookByID(Integer id);

    void add(Book book);

    void delete(Book book);

    Book getByUUID(String UUID);

}
