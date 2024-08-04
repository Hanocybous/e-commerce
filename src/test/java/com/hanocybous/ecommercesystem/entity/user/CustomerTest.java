package com.hanocybous.ecommercesystem.entity.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
    }

    @After
    public void tearDown() {
        customer = null;
    }

    @Test
    public void getRole() {
        UserType expected = UserType.fromString("CUSTOMER");
        UserType actual = customer.getRole();
        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        Customer customer1 = new Customer("John Doe", "johndoe", "johndoe@gmail.com", "password");
        Customer customer2 = new Customer("John Doe", "johndoe", "johndoe@gmail.com", "password");
        customer1.setAddress("123 Main St");
        customer1.setPhoneNumber("123-456-7890");
        customer1.setCity("Springfield");
        customer1.setCountry("USA");
        customer1.setZipCode("12345");
        customer1.setState("IL");

        customer2.setAddress("123 Main St");
        customer2.setPhoneNumber("123-456-7890");
        customer2.setCity("Springfield");
        customer2.setCountry("USA");
        customer2.setZipCode("12345");
        customer2.setState("IL");

        assertEquals(customer1, customer2);
    }

    @Test
    public void testHashCode() {
        Customer customer1 = new Customer("John Doe", "johndoe", "johndoe@gmail.com", "password");
        Customer customer2 = new Customer("John Doe", "johndoe", "johndoe@gmail.com", "password");
        customer1.setAddress("123 Main St");
        customer1.setPhoneNumber("123-456-7890");
        customer1.setCity("Springfield");
        customer1.setCountry("USA");
        customer1.setZipCode("12345");
        customer1.setState("IL");

        customer2.setAddress("123 Main St");
        customer2.setPhoneNumber("123-456-7890");
        customer2.setCity("Springfield");
        customer2.setCountry("USA");
        customer2.setZipCode("12345");
        customer2.setState("IL");

        assertEquals(customer1.hashCode(), customer2.hashCode());
    }
}