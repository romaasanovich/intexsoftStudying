package com.intexsoft.bookservice.web.controller;

import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.service.api.ReviewService;
import com.intexsoft.bookservice.service.api.UserService;
import com.intexsoft.bookservice.web.dto.entity.ReviewDto;
import com.intexsoft.bookservice.web.dto.mapper.ReviewDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewDtoMapper reviewDtoMapper;

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/review/user/{userId}")
    public Page<ReviewDto> getUserReviews(@PathVariable(name = "userId") Integer userId, Pageable pageable) {
        return reviewDtoMapper.toPageDto(reviewService.getUserReviews(userId, pageable));
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @GetMapping(path = "/reviews/{bookId}")
    public Page<ReviewDto> getBookReviews(@PathVariable(name = "bookId") Integer bookId, Pageable pageable) {
        return reviewDtoMapper.toPageDto(reviewService.getBookReviews(bookId, pageable));
    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('CUSTOMER')")
    @PostMapping(path = "/review")
    public void addReview(@RequestBody Review review) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.getByUsername(currentPrincipalName);
        review.setUser(user);
        reviewService.add(review);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/review/{id}")
    public void deleteReview(@PathVariable(name = "id") Integer id) {
        Review review = reviewService.getReviewByID(id).get();
        reviewService.delete(review);
    }
}
