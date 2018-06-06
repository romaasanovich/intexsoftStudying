package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.dao.entity.User;
import com.intexsoft.bookservice.dao.repository.ReviewRepository;
import com.intexsoft.bookservice.service.api.ReviewService;
import com.intexsoft.bookservice.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserService userService;

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public void add(Review review) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.getUserDyUsernameFromDb(currentPrincipalName);
        review.setUser(user);
        reviewRepository.save(review);
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
    public List<Review> getBookReview(Integer bookId) {
        return reviewRepository.findBookReview(bookId.toString());
    }

    @Override
    public List<Review> getUserReview(Integer userId) {
        return reviewRepository.findUserReview(userId.toString());
    }
}
