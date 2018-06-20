package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Author;
import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Publisher;
import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.dao.repository.BookRepository;
import com.intexsoft.bookservice.service.api.AuthorService;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.service.api.PublisherService;
import com.intexsoft.bookservice.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private ReviewService reviewService;

    @Override
    public Page<Book> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> getBookByID(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        for (Review review : reviewService.getAllBookreviews(book.getId())) {
            reviewService.delete(review);
        }
        bookRepository.delete(book);
    }

    @Override
    public Book getByUUID(String UUID) {
        return bookRepository.findUUID(UUID);
    }

    @Override
    public List<Book> getBestsellers(Double fromRate, Integer publisherId, Integer authorId) {
        Publisher publisher = publisherService.getPublisherByID(publisherId).orElse(null);
        Author author = authorService.getAuthorByID(authorId).orElse(null);
        return bookRepository.getBestSellers(fromRate, publisher, author);

    }

    @Override
    public List<Book> getByPriceInterval(Double minPrice, Double maxPrice, Integer publisherId, Integer authorId) {
        Publisher publisher = publisherService.getPublisherByID(publisherId).orElse(null);
        Author author = authorService.getAuthorByID(authorId).orElse(null);
        return bookRepository.getBooksByPriceInterval(minPrice, maxPrice, publisher, author);
    }

}
