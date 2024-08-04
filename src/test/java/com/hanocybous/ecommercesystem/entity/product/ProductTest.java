package com.hanocybous.ecommercesystem.entity.product;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = new Product("name", 10.0, "category", 10);
    }

    @After
    public void tearDown() {
        product = null;
    }

    @Test
    public void isAvailable() {
        assertTrue(product.isAvailable());
    }

    @Test
    public void decreaseQuantity() {
        product.decreaseQuantity();
        assertEquals(9, product.getQuantity());
    }

    @Test
    public void increaseQuantity() {
        product.increaseQuantity();
        assertEquals(11, product.getQuantity());
    }

    @Test
    public void getTotalPriceByQuantity() {
        // create multiple products
        Product product1 = new Product("name1", 10.0, "category1", 10);
        Product product2 = new Product("name2", 20.0, "category2", 20);
        Product product3 = new Product("name3", 30.0, "category3", 30);

        // check total price by quantity
        assertEquals(100.0, product1.getTotalPriceByQuantity(), 0.0);
        assertEquals(400.0, product2.getTotalPriceByQuantity(), 0.0);
        assertEquals(900.0, product3.getTotalPriceByQuantity(), 0.0);

        // check total price by quantity after increasing quantity
        product1.increaseQuantity();
        product2.increaseQuantity();
        product3.increaseQuantity();

        assertEquals(110.0, product1.getTotalPriceByQuantity(), 0.0);
        assertEquals(420.0, product2.getTotalPriceByQuantity(), 0.0);
        assertEquals(930.0, product3.getTotalPriceByQuantity(), 0.0);

    }

    @Test
    public void checkCategory() {
        product.setCategory("Books");
        assertEquals(product.getCategory(), ProductCategory.BOOKS.getName());
    }

    @Test
    public void calculateTotalPrice() {
        assertEquals(100.0, product.calculateTotalPrice(), 0.0);
    }

    @Test
    public void testEquals() {
        Product product1 = new Product("name", 10.0, "category", 10);
        Product product2 = new Product("name", 10.0, "category", 10);

        assertEquals(product1, product2);
    }

    @Test
    public void testHashCode() {
        Product product1 = new Product("name", 10.0, "category", 10);
        Product product2 = new Product("name", 10.0, "category", 10);

        assertEquals(product1.hashCode(), product2.hashCode());
    }
}