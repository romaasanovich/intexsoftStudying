package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.web.dto.entity.book.BookDetailsDto;
import com.intexsoft.bookservice.web.dto.entity.book.BookDto;
import com.intexsoft.bookservice.web.dto.mapper.book.BookDetailsDtoMapper;
import com.intexsoft.bookservice.web.dto.mapper.book.BookDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping(path = "/books")
    public Page<BookDto> getBooks(Pageable pageable) {
        return bookDtoMapper.toPageDto(bookService.getBooks(pageable));
    }

    @GetMapping(path = "/books/{id}")
    public BookDetailsDto getBookById(@PathVariable(name = "id") Integer id) {
        Book book = bookService.getBookById(id);
        return bookDetailsDtoMapper.toDto(book);
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
        Book book = bookService.getBookById(id);
        bookService.delete(book);
    }


    @GetMapping(path = "/books/bestsellers/crb")
    public List<Book> getBestSellersCrB(@Nullable @RequestParam(name = "fromRate") Double fromRate,
                                        @Nullable @RequestParam(name = "publisherId", defaultValue = "-1") Integer publisherId,
                                        @Nullable @RequestParam(name = "authorId", defaultValue = "-1") Integer authorId) {
        return bookService.getBestsellersCriteriaBuilder(fromRate, publisherId, authorId);
    }

    @GetMapping(path = "/books/price/crb")
    public List<Book> getBooksByPriceIntervalCrB(@Nullable @RequestParam(name = "minPrice") Double minPrice,
                                                 @Nullable @RequestParam(name = "maxPrice") Double maxPrice,
                                                 @Nullable @RequestParam(name = "publisherId", defaultValue = "-1") Integer publisherId,
                                                 @Nullable @RequestParam(name = "authorId", defaultValue = "-1") Integer authorId) {
        return bookService.getByPriceIntervalCriteriaBuilder(minPrice, maxPrice, publisherId, authorId);
    }

    @GetMapping(path = "/books/bestsellers/spec")
    public List<Book> getBestSellersSpec(@Nullable @RequestParam(name = "fromRate") Double fromRate,
                                         @Nullable @RequestParam(name = "publisherId", defaultValue = "-1") Integer publisherId,
                                         @Nullable @RequestParam(name = "authorId", defaultValue = "-1") Integer authorId) {
        return bookService.getBestsellersSpecification(fromRate, publisherId, authorId);
    }

    @GetMapping(path = "/books/price/spec")
    public List<Book> getBooksByPriceIntervalSpec(@Nullable @RequestParam(name = "minPrice") Double minPrice,
                                                  @Nullable @RequestParam(name = "maxPrice") Double maxPrice,
                                                  @Nullable @RequestParam(name = "publisherId", defaultValue = "-1") Integer publisherId,
                                                  @Nullable @RequestParam(name = "authorId", defaultValue = "-1") Integer authorId) {
        return bookService.getByPriceIntervalSpecification(minPrice, maxPrice, publisherId, authorId);
    }

    @GetMapping(path = "/books/bestsellers/dsl")
    public List<Book> getBestSellersDsl(@Nullable @RequestParam(name = "fromRate") Double fromRate,
                                        @Nullable @RequestParam(name = "publisherId", defaultValue = "-1") Integer publisherId,
                                        @Nullable @RequestParam(name = "authorId", defaultValue = "-1") Integer authorId) {
        return bookService.getBestsellersQueryDsl(fromRate, publisherId, authorId);
    }

    @GetMapping(path = "/books/price/dsl")
    public List<Book> getBooksByPriceIntervalDsl(@Nullable @RequestParam(name = "minPrice") Double minPrice,
                                                 @Nullable @RequestParam(name = "maxPrice") Double maxPrice,
                                                 @Nullable @RequestParam(name = "publisherId", defaultValue = "-1") Integer publisherId,
                                                 @Nullable @RequestParam(name = "authorId", defaultValue = "-1") Integer authorId) {
        return bookService.getByPriceIntervalQueryDsl(minPrice, maxPrice, publisherId, authorId);
    }

}
