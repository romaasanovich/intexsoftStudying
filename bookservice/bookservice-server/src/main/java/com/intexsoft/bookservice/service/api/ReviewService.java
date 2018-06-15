package com.intexsoft.bookservice.service.api;

import com.intexsoft.bookservice.dao.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> getAllReview();

    void add(Review review);

    void delete(Review review);

    Optional<Review> getReviewByID(Integer id);

    List<Review> getBookReviews(Integer bookId);

    List<Review> getUserReviews(Integer userId);


}
