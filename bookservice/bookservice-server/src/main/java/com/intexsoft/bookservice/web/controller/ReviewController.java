package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    ReviewService reviewService;
    private Review review;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/review/user/{userId}")
    public List<Review> getUserReviews(@PathVariable(name = "userId") Integer userId) {
        return reviewService.getUserReview(userId);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/review/book/{bookId}")
    public List<Review> getBookReviews(@PathVariable(name = "bookId") Integer bookId) {
        return reviewService.getBookReview(bookId);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @PostMapping(path = "/review")
    public void addReview(@RequestBody Review review) {
        reviewService.add(review);
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @DeleteMapping(path = "/review/{id}")
    public void deleteReview(@PathVariable(name = "id") Integer id) {
        review = reviewService.getReviewByID(id).orElse(null);
        reviewService.delete(review);
    }
}
