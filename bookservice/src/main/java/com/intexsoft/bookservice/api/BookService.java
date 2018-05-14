package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService  {
    List<Book> getAllBooks();
    Optional<Book> getBookByID(Integer id);
    public void exportToDb();
}
