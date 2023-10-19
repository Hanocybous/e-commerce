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
        if (!super.equals(o)) return false;
        if (!getId().equals(review.getId())) return false;
        if (!getProduct().equals(review.getProduct())) return false;
        if (!getCustomer().equals(review.getCustomer())) return false;
        if (!getRating().equals(review.getRating())) return false;
        if (!getComment().equals(review.getComment())) return false;
        if (!getReviewDate().equals(review.getReviewDate())) return false;
        return getIsApproved().equals(review.getIsApproved());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getId().hashCode();
        result = 31 * result + getProduct().hashCode();
        result = 31 * result + getCustomer().hashCode();
        result = 31 * result + getRating().hashCode();
        result = 31 * result + getComment().hashCode();
        result = 31 * result + getReviewDate().hashCode();
        result = 31 * result + getIsApproved().hashCode();
        return result;
    }


}
