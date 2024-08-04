package com.hanocybous.ecommercesystem.entity.review;

import com.hanocybous.ecommercesystem.entity.product.Product;
import com.hanocybous.ecommercesystem.entity.user.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
public class ReviewTest {

    private Review review;
    private Product product;
    private Customer customer;

    @Before
    public void setUp() {
        review = new Review();
        product = new Product();
        customer = new Customer();
    }

    @After
    public void tearDown() {
        review = null;
        product = null;
        customer = null;
    }

    @Test
    public void testEquals() {
        Review review1 = new Review(product, customer, 5, "Great product", null);
        Review review2 = new Review(product, customer, 5, "Great product", null);
        assertEquals(review1, review2);
    }

    @Test
    public void testHashCode() {
        Review review1 = new Review(product, customer, 5, "Great product", null);
        Review review2 = new Review(product, customer, 5, "Great product", null);
        assertEquals(review1.hashCode(), review2.hashCode());
    }

    @Test
    public void testUpdateReview() {
        String title = "Product";
        Integer rating = 5;
        String comment = "Great product";
        review.updateReview(title, rating, comment);
        assertEquals(title, review.getTitle());
        assertEquals(rating, review.getRating());
        assertEquals(comment, review.getComment());
    }

    @Test
    public void updateReviewTitle() {
        String title = "Product";
        review.updateReviewTitle(title);
        assertEquals(title, review.getTitle());
    }

    @Test
    public void updateReviewRating() {
        Integer rating = 5;
        review.updateReviewRating(rating);
        assertEquals(rating, review.getRating());
    }

    @Test
    public void updateReviewComment() {
        String comment = "Great product";
        review.updateReviewComment(comment);
        assertEquals(comment, review.getComment());
    }
}