package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.web.dto.entity.book.BookDetailsDto;
import com.intexsoft.bookservice.web.dto.entity.book.BookDto;
import com.intexsoft.bookservice.web.dto.mapper.book.BookDetailsDtoMapper;
import com.intexsoft.bookservice.web.dto.mapper.book.BookDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDtoMapper bookDtoMapper;

    @Autowired
    private BookDetailsDtoMapper bookDetailsDtoMapper;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/books/{page}/{size}")
    public Page<BookDto> getBooks(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        return bookDtoMapper.toPageDto(bookService.getBooks(page, size));
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/books/{id}")
    public BookDetailsDto getBookById(@PathVariable(name = "id") Integer id) {
        Optional<Book> book = bookService.getBookByID(id);
        return bookDetailsDtoMapper.toDto(book.get());
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
