package com.hanocybous.ecommercesystem.entity.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {

    private Admin admin;

    @Before
    public void setUp() {
        admin = new Admin("John Doe",
                "johndoe",
                "johndoe@gmail.com",
                "password",
                123456L);
    }

    @After
    public void tearDown() {
        admin = null;
    }

    @Test
    public void getRole() {
        assertEquals(UserType.fromString("ADMIN"), admin.getRole());
    }

    @Test
    public void testEquals() {
        Admin admin2 = new Admin("John Doe",
                "johndoe",
                "johndoe@gmail.com",
                "password",
                123456L);
        assertEquals(admin, admin2);
    }

    @Test
    public void testHashCode() {
        Admin admin2 = new Admin("John Doe",
                "johndoe",
                "johndoe@gmail.com",
                "password",
                123456L);
        assertEquals(admin.hashCode(), admin2.hashCode());
    }
}