package com.hanocybous.ecommercesystem.entity.cart;

import com.hanocybous.ecommercesystem.entity.product.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
public class CartTest {

    private Cart cart;
    private Product product;
    private List<Product> products;

    @Before
    public void setUp() {
        cart = new Cart();
        product = new Product();
        products = new ArrayList<>();
    }

    @After
    public void tearDown() {
        cart = null;
        product = null;
        products = null;
    }

    @Test
    public void addProduct() {
        cart.setProducts(products);
        cart.addProduct(product);
        Collection<Product> products = cart.getProducts();
        assertEquals(1, products.size());
    }

    @Test
    public void removeProduct() {
       cart.setProducts(products);
       cart.addProduct(product);
       cart.removeProduct(product);
       Collection<Product> products = cart.getProducts();
       assertEquals(0, products.size());
    }

    @Test
    public void clearCart() {
        cart.setProducts(products);
        cart.addProduct(product);
        cart.clearCart();
        Collection<Product> products = cart.getProducts();
        assertEquals(0, products.size());
    }

    @Test
    public void calculateTotalAmount() {
        cart.setProducts(products);
        cart.addProduct(product);
        cart.calculateTotalAmount();
        double totalAmount = cart.getTotalAmount();
        assertEquals(0.0, totalAmount, 0.0);
    }

    @Test
    public void testEquals() {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        cart1.setProducts(products);
        cart2.setProducts(products);
        assertEquals(cart1, cart2);
    }

    @Test
    public void testHashCode() {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        cart1.setProducts(products);
        cart2.setProducts(products);
        assertEquals(cart1.hashCode(), cart2.hashCode());
    }
}