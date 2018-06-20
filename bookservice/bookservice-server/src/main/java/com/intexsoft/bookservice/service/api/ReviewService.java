package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> getAllReview();

    void add(Review review);

    void delete(Review review);

    Optional<Review> getReviewByID(Integer id);

    Page<Review> getBookReviews(Integer bookId, Pageable pageable);

    Page<Review> getUserReviews(Integer userId, Pageable pageable);


    List<Review> getAllBookreviews(Integer bookId);
}
