package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.dao.repository.BookRepository;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewService reviewService;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
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
        for (Review review : reviewService.getBookReview(book.getId())) {
            reviewService.delete(review);
        }
        bookRepository.delete(book);

    }

    @Override
    public Book getByUUID(String UUID) {
        return bookRepository.findUUID(UUID);
    }

}
