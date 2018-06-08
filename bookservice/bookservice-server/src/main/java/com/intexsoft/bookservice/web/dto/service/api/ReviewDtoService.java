package com.intexsoft.bookservice.web.dto.service.api;

import com.intexsoft.bookservice.dao.entity.Review;
import com.intexsoft.bookservice.web.dto.entity.ReviewDto;

import java.util.List;

public interface ReviewDtoService {
    List<ReviewDto> getListReviewsDto(List<Review> reviews);

    ReviewDto toDto(Review review);
}
