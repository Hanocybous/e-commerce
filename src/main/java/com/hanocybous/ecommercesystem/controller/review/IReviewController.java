package com.hanocybous.ecommercesystem.controller.review;

import com.hanocybous.ecommercesystem.dto.review.ReviewDto;

import java.util.List;

public interface IReviewController {

    List<ReviewDto> getReviewsByProductId(Long productId);

    List<ReviewDto> getReviewsByProductIdAndUserId(Long productId, Long customerId);

    List<ReviewDto> getReviewsByCustomerId(Long customerId);

    List<ReviewDto> getReviewsByTitle(String title);

    List<ReviewDto> getReviewsByRating(Integer rating);

    ReviewDto addReview(ReviewDto reviewDto);

    ReviewDto updateReview(ReviewDto reviewDto);

    void deleteReview(Long reviewId);

    void deleteReviewsByCustomerId(Long customerId);

    void deleteReviewsByProductId(Long productId);

    void deleteReviewsByTitle(String title);

}
