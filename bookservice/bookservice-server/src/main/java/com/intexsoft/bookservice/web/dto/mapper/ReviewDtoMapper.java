package com.intexsoft.bookservice.web.dto.mapper;

import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.web.dto.entity.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoMapper extends AbstractDtoMapper<Review, ReviewDto> {

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
