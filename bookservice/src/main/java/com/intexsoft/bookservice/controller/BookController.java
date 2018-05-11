package com.intexsoft.bookservice.controller;

import com.intexsoft.bookservice.api.BookService;
import com.intexsoft.bookservice.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(name = "/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }


    @PostMapping(name = "/books")
    public Book getBookBiId(@RequestParam(name = "id") Integer id) {
        Optional<Book> book = bookService.getBookByID(id);
        return book.get();
    }
}
