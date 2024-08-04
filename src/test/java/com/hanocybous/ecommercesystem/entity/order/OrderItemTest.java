package com.hanocybous.ecommercesystem.entity.order;

import com.hanocybous.ecommercesystem.entity.product.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
public class OrderItemTest {

    private OrderItem orderItem;
    private EOrder order;
    private Product product;
    private List<OrderItem> orderItems;

    @Before
    public void setUp() {
        product = new Product("product", 10.0, 10);
        order = new EOrder();
        orderItem = new OrderItem(product, order, 10, 10.0, 100.0);
        orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        order.setOrderItems(orderItems);
    }

    @After
    public void tearDown() {
        orderItem = null;
        order = null;
        product = null;
        orderItems = null;
    }

    @Test
    public void testEquals() {
        OrderItem orderItem1 = new OrderItem(product, order, 10, 10.0, 100.0);
        OrderItem orderItem2 = new OrderItem(product, order, 10, 10.0, 100.0);
        assertEquals(orderItem1, orderItem2);
    }

    @Test
    public void testHashCode() {
        // FIXME: This test showed that the hashCode method is not implemented correctly due to
        //  a StackOverflowError. The hashCode method should be implemented correctly.
        OrderItem orderItem1 = new OrderItem(product, order, 10, 10.0, 100.0);
        OrderItem orderItem2 = new OrderItem(product, order, 10, 10.0, 100.0);
        assertEquals(orderItem1.hashCode(), orderItem2.hashCode());
    }
}