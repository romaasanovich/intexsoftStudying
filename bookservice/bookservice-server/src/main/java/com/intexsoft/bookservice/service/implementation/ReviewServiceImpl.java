package com.intexsoft.bookservice.service.implementation;

import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.dao.repository.ReviewRepository;
import com.intexsoft.bookservice.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public void add(Review review) {
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
