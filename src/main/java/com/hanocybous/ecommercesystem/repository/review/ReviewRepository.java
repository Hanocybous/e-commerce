package com.hanocybous.ecommercesystem.repository.review;

import com.hanocybous.ecommercesystem.dto.review.ReviewDto;
import com.hanocybous.ecommercesystem.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE product_id = ?1", nativeQuery = true)
    List<ReviewDto> getReviewsByProductId(Long productId);

    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE product_id = ?1 " +
            "AND customer_id = ?2", nativeQuery = true)
    List<ReviewDto> getReviewsByProductIdAndUserId(Long productId, Long customerId);

    // get review by customer id
    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE customer_id = ?1", nativeQuery = true)
    List<ReviewDto> getReviewsByCustomerId(Long customerId);

    // get review by title
    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE title = ?1", nativeQuery = true)
    List<ReviewDto> getReviewsByTitle(String title);

    // get review by rating
    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE rating = ?1", nativeQuery = true)
    List<ReviewDto> getReviewsByRating(Integer rating);

    // get review by comment
    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE comment = ?1", nativeQuery = true)
    List<ReviewDto> getReviewsByComment(String comment);

    // get review by review date
    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE review_date = ?1", nativeQuery = true)
    List<ReviewDto> getReviewsByReviewDate(LocalDateTime reviewDate);

    // add review by product id
    @Modifying
    @Query(value =
            "INSERT INTO review (product_id, customer_id, title, rating, comment, review_date) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    List<ReviewDto> addReviewByProductId(Long productId,
                                         Long customerId,
                                         String title,
                                         Integer rating,
                                         String comment,
                                         LocalDateTime reviewDate);

    // update review by product id
    @Modifying
    @Query(value =
            "UPDATE review " +
            "SET title = ?1, rating = ?2, comment = ?3, review_date = ?4 " +
            "WHERE product_id = ?5", nativeQuery = true)
    List<ReviewDto> updateReviewByProductId(String title,
                                            Integer rating,
                                            String comment,
                                            LocalDateTime reviewDate,
                                            Long productId);

    // delete review by product id
    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE product_id = ?1", nativeQuery = true)
    List<ReviewDto> deleteReviewByProductId(Long productId);

    // delete review by product id and customer id
    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE product_id = ?1 " +
            "AND customer_id = ?2", nativeQuery = true)
    List<ReviewDto> deleteReviewByProductIdAndCustomerId(Long productId, Long customerId);

    // delete review by customer id
    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE customer_id = ?1", nativeQuery = true)
    List<ReviewDto> deleteReviewByCustomerId(Long customerId);

    // delete review by title
    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE title = ?1", nativeQuery = true)
    List<ReviewDto> deleteReviewByTitle(String title);

    // delete review by rating
    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE rating = ?1", nativeQuery = true)
    List<ReviewDto> deleteReviewByRating(Integer rating);

    // delete review by comment
    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE comment = ?1", nativeQuery = true)
    List<ReviewDto> deleteReviewByComment(String comment);

    // delete review by review date
    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE review_date = ?1", nativeQuery = true)
    List<ReviewDto> deleteReviewByReviewDate(LocalDateTime reviewDate);

    // delete review by review date between
    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE review_date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<ReviewDto> deleteReviewByReviewDateBetween(LocalDateTime reviewDateStart,
                                                    LocalDateTime reviewDateEnd);

    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE review_date BETWEEN ?1 AND ?2", nativeQuery = true)
    List<ReviewDto> getReviewsByReviewDateBetween(LocalDateTime reviewDateStart,
                                                  LocalDateTime reviewDateEnd);

    @Modifying
    @Query(value =
            "SELECT * " +
            "FROM review " +
            "WHERE product_id = ?1 " +
            "AND customer_id = ?2 " +
            "AND title = ?3 " +
            "AND rating = ?4 " +
            "AND comment = ?5 " +
            "AND review_date = ?6", nativeQuery = true)
    List<ReviewDto> updateReviewByProductId(Long productId,
                                            Long customerId,
                                            String title,
                                            Integer rating,
                                            String comment,
                                            LocalDateTime reviewDate);

    @Modifying
    @Query(value =
            "INSERT INTO review (product_id, customer_id, title, rating, comment, review_date) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    ReviewDto addReview(ReviewDto reviewDto);

    @Modifying
    @Query(value =
            "UPDATE review " +
            "SET title = ?1, rating = ?2, comment = ?3, review_date = ?4 " +
            "WHERE product_id = ?5", nativeQuery = true)
    ReviewDto updateReview(ReviewDto reviewDto);

    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE product_id = ?1", nativeQuery = true)
    void deleteReview(Long reviewId);

    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE product_id = ?1", nativeQuery = true)
    void deleteReviewsByProductId(Long productId);

    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE customer_id = ?1", nativeQuery = true)
    void deleteReviewsByCustomerId(Long customerId);

    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE title = ?1", nativeQuery = true)
    void deleteReviewsByTitle(String title);

    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE rating = ?1", nativeQuery = true)
    void deleteReviewsByRating(Integer rating);

    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE comment = ?1", nativeQuery = true)
    void deleteReviewsByComment(String comment);

    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE review_date = ?1", nativeQuery = true)
    void deleteReviewsByReviewDate(LocalDateTime reviewDate);

    @Modifying
    @Query(value =
            "DELETE FROM review " +
            "WHERE review_date BETWEEN ?1 AND ?2", nativeQuery = true)
    void deleteReviewsByReviewDateBetween(LocalDateTime reviewDateStart, LocalDateTime reviewDateEnd);
}
