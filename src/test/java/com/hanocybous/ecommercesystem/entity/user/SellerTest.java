package com.hanocybous.ecommercesystem.entity.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellerTest {

    Seller seller;

    @Before
    public void setUp() {
        seller = new Seller("Private Seller",
                "seller",
                "123-456-7890",
                "password",
                "Company Name",
                "Company Address",
                "123-456-7890");
    }

    @After
    public void tearDown() {
        seller = null;
    }

    @Test
    public void getRole() {
        assertEquals(UserType.SELLER, seller.getRole());
    }

    @Test
    public void testEquals() {
        Seller seller1 = new Seller("Private Seller",
                "seller",
                "123-456-7890",
                "password",
                "Company Name",
                "Company Address",
                "123-456-7890");
        assertEquals(seller, seller1);
    }

    @Test
    public void testHashCode() {
        Seller seller1 = new Seller("Private Seller",
                "seller",
                "123-456-7890",
                "password",
                "Company Name",
                "Company Address",
                "123-456-7890");
        assertEquals(seller.hashCode(), seller1.hashCode());
    }
}