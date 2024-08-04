package com.hanocybous.ecommercesystem.entity.review;

import com.hanocybous.ecommercesystem.entity.product.Product;
import com.hanocybous.ecommercesystem.entity.user.Customer;
import com.hanocybous.ecommercesystem.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    private String title;

    private Integer rating;

    private String comment;

    private LocalDateTime reviewDate;

    @Transient
    private Boolean isApproved;

    public Review(Product product,
                  Customer customer,
                  Integer rating,
                  String comment,
                  LocalDateTime reviewDate) {
        this.product = product;
        this.customer = customer;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public Review(Product product,
                  Customer customer,
                  Integer rating,
                  String comment,
                  LocalDateTime reviewDate,
                  Boolean isApproved) {
        this.product = product;
        this.customer = customer;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.isApproved = isApproved;
    }

    public Review(Product product,
                  Customer customer,
                  Integer rating,
                  String comment) {
        this.product = product;
        this.customer = customer;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = LocalDateTime.now();
    }

    public Review(Product product,
                  Customer customer,
                  Integer rating) {
        this.product = product;
        this.customer = customer;
        this.rating = rating;
        this.reviewDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", product=" + product +
                ", customer=" + customer +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                ", isApproved=" + isApproved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;

        return getProduct().equals(review.getProduct()) &&
                getCustomer().equals(review.getCustomer()) &&
                getRating().equals(review.getRating()) &&
                getComment().equals(review.getComment());

    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + getProduct().hashCode();
        result = 31 * result + getCustomer().hashCode();
        result = 31 * result + getRating().hashCode();
        result = 31 * result + getComment().hashCode();
        return result;
    }

    public void approveReview() {
        this.isApproved = true;
    }

    public void disapproveReview() {
        this.isApproved = false;
    }

    public void updateReview(String title, Integer rating, String comment) {
        this.title = title;
        this.rating = rating;
        this.comment = comment;
    }

    public void updateReview(Integer rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public void updateReview(String comment) {
        this.comment = comment;
    }

    public void updateReviewTitle(String title) {
        this.title = title;
    }

    public void updateReviewRating(Integer rating) {
        this.rating = rating;
    }

    public void updateReviewComment(String comment) {
        this.comment = comment;
    }

}
