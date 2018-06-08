package com.intexsoft.bookservice.web.dto.service.implementation;

import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.web.dto.entity.ReviewDto;
import com.intexsoft.bookservice.web.dto.service.api.ReviewDtoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewDtoServiceImpl implements ReviewDtoService {

    @Override
    public List<ReviewDto> getListReviewsDto(List<Review> reviews) {
        List<ReviewDto> reviewsDto = new ArrayList<>();
        for (Review review : reviews) {
            reviewsDto.add(toDto(review));
        }
        return reviewsDto;
    }

    @Override
    public ReviewDto toDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setReview(review.getReview());
        reviewDto.setRate(review.getRate());
        reviewDto.setUsername(review.getUser().getUsername());
        return reviewDto;
    }
}
