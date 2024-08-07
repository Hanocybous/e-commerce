package com.hanocybous.ecommercesystem.controller.review.reviewcontrollerimpl;

import com.hanocybous.ecommercesystem.controller.review.IReviewController;
import com.hanocybous.ecommercesystem.dto.review.ReviewDto;
import com.hanocybous.ecommercesystem.service.review.reviewimpl.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/review")
public class ReviewController implements IReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/product/{productId}")
    public List<ReviewDto> getReviewsByProductId(
            @PathVariable
            @RequestBody Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    @GetMapping("/product/{productId}/customer/{customerId}")
    public List<ReviewDto> getReviewsByProductIdAndUserId(
            @PathVariable
            @RequestBody Long productId,
            @PathVariable
            @RequestBody Long customerId) {
        return reviewService.getReviewsByProductIdAndUserId(productId,
                customerId);
    }

    @GetMapping("/review/customer/{customerId}")
    public List<ReviewDto> getReviewsByCustomerId(
            @PathVariable
            @RequestBody Long customerId) {
        return reviewService.getReviewsByCustomerId(customerId);
    }

    @GetMapping("/review/title/{title}")
    public List<ReviewDto> getReviewsByTitle(
            @PathVariable
            @RequestBody String title) {
        return reviewService.getReviewsByTitle(title);
    }

    @GetMapping("/review/rating/{rating}")
    public List<ReviewDto> getReviewsByRating(
            @PathVariable
            @RequestBody Integer rating) {
        return reviewService.getReviewsByRating(rating);
    }

    @GetMapping("/review/comment/{comment}")
    public List<ReviewDto> getReviewsByComment(
            @PathVariable
            @RequestBody String comment) {
        return reviewService.getReviewsByComment(comment);
    }

    @GetMapping("/review/reviewDate/{reviewDate}")
    public List<ReviewDto> getReviewsByReviewDate(
            @PathVariable
            @RequestBody LocalDateTime reviewDate) {
        return reviewService.getReviewsByReviewDate(reviewDate);
    }

    @GetMapping("/review/reviewDate/{reviewDateStart}/{reviewDateEnd}")
    public List<ReviewDto> getReviewsByReviewDateBetween(
            @PathVariable
            @RequestBody LocalDateTime reviewDateStart,
            @PathVariable
            @RequestBody LocalDateTime reviewDateEnd) {
        return reviewService.getReviewsByReviewDateBetween(reviewDateStart,
                reviewDateEnd);
    }

    @PostMapping("/review")
    public ReviewDto addReview(
            @RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

    @PutMapping("/review")
    public ReviewDto updateReview(
            @RequestBody ReviewDto reviewDto) {
        return reviewService.updateReview(reviewDto);
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(
            @PathVariable
            @RequestBody Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @DeleteMapping("/review/product/{productId}")
    public void deleteReviewsByProductId(
            @PathVariable
            @RequestBody Long productId) {
        reviewService.deleteReviewsByProductId(productId);
    }

    @DeleteMapping("/review/customer/{customerId}")
    public void deleteReviewsByCustomerId(
            @PathVariable
            @RequestBody Long customerId) {
        reviewService.deleteReviewsByCustomerId(customerId);
    }

    @DeleteMapping("/review/title/{title}")
    public void deleteReviewsByTitle(
            @PathVariable
            @RequestBody String title) {
        reviewService.deleteReviewsByTitle(title);
    }

    @DeleteMapping("/review/rating/{rating}")
    public void deleteReviewsByRating(
            @PathVariable
            @RequestBody Integer rating) {
        reviewService.deleteReviewsByRating(rating);
    }

    @DeleteMapping("/review/comment/{comment}")
    public void deleteReviewsByComment(
            @PathVariable
            @RequestBody String comment) {
        reviewService.deleteReviewsByComment(comment);
    }

    @DeleteMapping("/review/reviewDate/{reviewDate}")
    public void deleteReviewsByReviewDate(
            @PathVariable
            @RequestBody LocalDateTime reviewDate) {
        reviewService.deleteReviewsByReviewDate(reviewDate);
    }

    @DeleteMapping("/review/{reviewDateStart}/{reviewDateEnd}")
    public void deleteReviewsByReviewDateBetween(
            @PathVariable
            @RequestBody LocalDateTime reviewDateStart,
            @PathVariable
            @RequestBody LocalDateTime reviewDateEnd) {
        reviewService.deleteReviewsByReviewDateBetween(reviewDateStart,
                reviewDateEnd);
    }

}
