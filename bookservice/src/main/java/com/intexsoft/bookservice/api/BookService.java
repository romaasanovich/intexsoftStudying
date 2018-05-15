package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.entity.Book;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BookService  {
    @Transactional
    List<Book> getAllBooks();

    @Transactional
    Optional<Book> getBookByID(Integer id);

    @Transactional
    void add(Book book);

    @Transactional
    void delete(Book book);

    @Transactional
    void exportToDB(ArrayList<Book> authors);
}
