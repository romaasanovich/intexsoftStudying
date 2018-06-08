package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.web.dto.entity.BookDto;
import com.intexsoft.bookservice.web.dto.service.api.BookDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDtoService bookDtoService;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/books")
    public List<BookDto> getBooks() {
        return bookDtoService.getListBooksDto(bookService.getAllBooks());
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/books/{id}")
    public BookDto getBookById(@PathVariable(name = "id") Integer id) {
        Optional<Book> book = bookService.getBookByID(id);
        return bookDtoService.toDto(book.get());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(path = "/book")
    public void addBook(@RequestBody Book book) {
        book.setUuid(UUID.randomUUID().toString());
        bookService.add(book);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/book/{id}")
    public void deleteBook(@PathVariable(name = "id") Integer id) {
        Book book = bookService.getBookByID(id).get();
        bookService.delete(book);
    }


}
