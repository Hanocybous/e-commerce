package com.hanocybous.ecommercesystem.service.review;

import com.hanocybous.ecommercesystem.dto.review.ReviewDto;

import java.util.List;

public interface IReviewService {

    List<ReviewDto> getReviewsByProductId(Long productId);

    List<ReviewDto> getReviewsByProductIdAndUserId(Long productId,
                                                   Long customerId);

    List<ReviewDto> getReviewsByCustomerId(Long customerId);

    List<ReviewDto> getReviewsByTitle(String title);

    List<ReviewDto> getReviewsByRating(Integer rating);

}
