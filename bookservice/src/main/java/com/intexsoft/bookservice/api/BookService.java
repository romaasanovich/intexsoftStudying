package com.intexsoft.bookservice.api;

import com.intexsoft.bookservice.entity.Book;
import com.intexsoft.bookservice.jsonentitiy.BookJson;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Optional<Book> getBookByID(Integer id);

    void add(Book book);

    void delete(Book book);

 //   Book getByUUID(String UUID);

    void exportToDB(List<BookJson> authors);

}
