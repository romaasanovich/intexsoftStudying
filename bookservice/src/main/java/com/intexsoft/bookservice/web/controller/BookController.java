package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping(path = "/books/{id}")
    public Book getBookBiId(@PathVariable(name = "id") Integer id) {
        Optional<Book> book = bookService.getBookByID(id);
        return book.get();
    }

}
