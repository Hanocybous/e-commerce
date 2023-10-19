package com.hanocybous.ecommercesystem.service.review.reviewimpl;

import com.hanocybous.ecommercesystem.dto.review.ReviewDto;
import com.hanocybous.ecommercesystem.repository.review.ReviewRepository;
import com.hanocybous.ecommercesystem.service.review.IReviewService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@Getter
@SuppressWarnings("unused")
public class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ReviewDto> getReviewsByProductId(Long productId) {
        if (productId == null) {
            return Collections.emptyList();
        }
        return reviewRepository.getReviewsByProductId(productId);
    }

    public List<ReviewDto> getReviewsByProductIdAndUserId(Long productId,
                                                          Long customerId) {
        if (productId == null ||
                customerId == null) {
            return Collections.emptyList();
        }
        return reviewRepository.getReviewsByProductIdAndUserId(productId,
                customerId);
    }

    public List<ReviewDto> getReviewsByCustomerId(Long customerId) {
        if (customerId == null) {
            return Collections.emptyList();
        }
        return reviewRepository.getReviewsByCustomerId(customerId);
    }

    public List<ReviewDto> getReviewsByTitle(String title) {
        if (title == null) {
            return Collections.emptyList();
        }
        return reviewRepository.getReviewsByTitle(title);
    }

    public List<ReviewDto> getReviewsByRating(Integer rating) {
        if (rating == null) {
            return Collections.emptyList();
        }
        return reviewRepository.getReviewsByRating(rating);
    }

    public List<ReviewDto> getReviewsByComment(String comment) {
        if (comment == null) {
            return Collections.emptyList();
        }
        return reviewRepository.getReviewsByComment(comment);
    }

    public List<ReviewDto> getReviewsByReviewDate(LocalDateTime reviewDate) {
        if (reviewDate == null) {
            return Collections.emptyList();
        }
        return reviewRepository.getReviewsByReviewDate(reviewDate);
    }

    public List<ReviewDto> getReviewsByReviewDateBetween(LocalDateTime reviewDateStart,
                                                         LocalDateTime reviewDateEnd) {
        if (reviewDateStart == null ||
                reviewDateEnd == null) {
            return Collections.emptyList();
        }
        return reviewRepository.getReviewsByReviewDateBetween(reviewDateStart,
                reviewDateEnd);
    }

    public List<ReviewDto> addReviewByProductId(Long productId,
                                                Long customerId,
                                                String title,
                                                Integer rating,
                                                String comment,
                                                LocalDateTime reviewDate) {
        if (productId == null ||
                customerId == null ||
                title == null ||
                rating == null ||
                comment == null ||
                reviewDate == null) {
            return Collections.emptyList();
        }
        return reviewRepository.addReviewByProductId(productId,
                customerId,
                title,
                rating,
                comment,
                reviewDate);
    }

    public List<ReviewDto> updateReviewByProductId(Long productId,
                                                   Long customerId,
                                                   String title,
                                                   Integer rating,
                                                   String comment,
                                                   LocalDateTime reviewDate) {
        if (productId == null ||
                customerId == null ||
                title == null ||
                rating == null ||
                comment == null ||
                reviewDate == null) {
            return Collections.emptyList();
        }
        return reviewRepository.updateReviewByProductId(productId,
                customerId,
                title,
                rating,
                comment,
                reviewDate);
    }

    public List<ReviewDto> deleteReviewByProductId(Long productId) {
        if (productId == null) {
            return Collections.emptyList();
        }
        return reviewRepository.deleteReviewByProductId(productId);
    }

    public List<ReviewDto> deleteReviewByProductIdAndCustomerId(Long productId,
                                                                Long customerId) {
        if (productId == null ||
                customerId == null) {
            return Collections.emptyList();
        }
        return reviewRepository.deleteReviewByProductIdAndCustomerId(productId,
                customerId);
    }

    public List<ReviewDto> deleteReviewByCustomerId(Long customerId) {
        if (customerId == null) {
            return Collections.emptyList();
        }
        return reviewRepository.deleteReviewByCustomerId(customerId);
    }

    public List<ReviewDto> deleteReviewByTitle(String title) {
        if (title == null) {
            return Collections.emptyList();
        }
        return reviewRepository.deleteReviewByTitle(title);
    }

    public List<ReviewDto> deleteReviewByRating(Integer rating) {
        if (rating == null) {
            return Collections.emptyList();
        }
        return reviewRepository.deleteReviewByRating(rating);
    }

    public List<ReviewDto> deleteReviewByComment(String comment) {
        if (comment == null) {
            return Collections.emptyList();
        }
        return reviewRepository.deleteReviewByComment(comment);
    }

    public List<ReviewDto> deleteReviewByReviewDate(LocalDateTime reviewDate) {
        if (reviewDate == null) {
            return Collections.emptyList();
        }
        return reviewRepository.deleteReviewByReviewDate(reviewDate);
    }

    public List<ReviewDto> deleteReviewByReviewDateBetween(LocalDateTime reviewDateStart,
                                                           LocalDateTime reviewDateEnd) {
        if (reviewDateStart == null ||
                reviewDateEnd == null) {
            return Collections.emptyList();
        }
        return reviewRepository.deleteReviewByReviewDateBetween(reviewDateStart,
                reviewDateEnd);
    }

    public ReviewDto addReview(ReviewDto reviewDto) {
        if (reviewDto == null) {
            return null;
        }
        return reviewRepository.addReview(reviewDto);
    }

    public ReviewDto updateReview(ReviewDto reviewDto) {
        if (reviewDto == null) {
            return null;
        }
        return reviewRepository.updateReview(reviewDto);
    }

    public void deleteReview(Long reviewId) {
        if (reviewId == null) {
            return;
        }
        reviewRepository.deleteReview(reviewId);
    }

    public void deleteReviewsByProductId(Long productId) {
        if (productId == null) {
            return;
        }
        reviewRepository.deleteReviewsByProductId(productId);
    }

    public void deleteReviewsByCustomerId(Long customerId) {
        if (customerId == null) {
            return;
        }
        reviewRepository.deleteReviewsByCustomerId(customerId);
    }

    public void deleteReviewsByTitle(String title) {
        if (title == null) {
            return;
        }
        reviewRepository.deleteReviewsByTitle(title);
    }

    public void deleteReviewsByRating(Integer rating) {
        if (rating == null) {
            return;
        }
        reviewRepository.deleteReviewsByRating(rating);
    }

    public void deleteReviewsByComment(String comment) {
        if (comment == null) {
            return;
        }
        reviewRepository.deleteReviewsByComment(comment);
    }

    public void deleteReviewsByReviewDate(LocalDateTime reviewDate) {
        if (reviewDate == null) {
            return;
        }
        reviewRepository.deleteReviewsByReviewDate(reviewDate);
    }


    public void deleteReviewsByReviewDateBetween(LocalDateTime reviewDateStart, LocalDateTime reviewDateEnd) {
        if (reviewDateStart == null ||
                reviewDateEnd == null) {
            return;
        }
        reviewRepository.deleteReviewsByReviewDateBetween(reviewDateStart,
                reviewDateEnd);
    }

}
