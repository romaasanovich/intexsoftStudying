package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Book;
import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.dao.repository.ReviewRepository;
import com.intexsoft.bookservice.service.api.BookService;
import com.intexsoft.bookservice.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookService bookService;

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public void add(Review review) {
        reviewRepository.save(review);
        Book bookReview = bookService.getBookByID(review.getBook().getId()).get();
        bookReview.setRate(getRate(bookReview));
    }

    @Override
    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    @Override
    public Optional<Review> getReviewByID(Integer id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> getBookReviews(Integer bookId) {
        return reviewRepository.findBookReview(bookId);
    }

    @Override
    public List<Review> getUserReviews(Integer userId) {
        return reviewRepository.findUserReview(userId);
    }

    private Double getRate(Book book) {
        List<Review> reviews = getBookReviews(book.getId());
        Double sumRate = 0.0;
        for (Review review : reviews) {
            sumRate += review.getRate();
        }
        Double rate = (sumRate != 0) ? (sumRate / reviews.size()) : 0.0;
        return Double.valueOf(new DecimalFormat("#.#").format(rate));
    }
}
