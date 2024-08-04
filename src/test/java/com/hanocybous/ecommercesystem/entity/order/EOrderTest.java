package com.hanocybous.ecommercesystem.entity.order;

import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
public class EOrderTest {

    private EOrder eOrder;
    private List<OrderItem> orderItems;

    @Before
    public void setUp() {
        eOrder = new EOrder();
        orderItems = new ArrayList<>();
    }

    @After
    public void tearDown() {
        eOrder = null;
        orderItems = null;
    }

    @Test
    public void testEquals() {
        EOrder o = new EOrder();
        eOrder.setPaymentMethod(PaymentMethod.CREDIT_CARD.getPaymentMethod());
        o.setPaymentMethod(PaymentMethod.CREDIT_CARD.getPaymentMethod());
        eOrder.setOrderItems(orderItems);
        o.setOrderItems(orderItems);
        assertEquals(eOrder, o);
    }

    @Test
    public void testHashCode() {
        EOrder o = new EOrder();
        eOrder.setPaymentMethod(PaymentMethod.CREDIT_CARD.getPaymentMethod());
        o.setPaymentMethod(PaymentMethod.CREDIT_CARD.getPaymentMethod());
        eOrder.setOrderItems(orderItems);
        o.setOrderItems(orderItems);
        assertEquals(eOrder.hashCode(), o.hashCode());
    }

    @Test
    public void addOrderItem() {
        eOrder.setOrderItems(orderItems);
        eOrder.addOrderItem(new OrderItem());
        assertEquals(1, eOrder.getOrderItems().size());
    }

    @Test
    public void removeOrderItem() {
        OrderItem orderItem = new OrderItem();
        eOrder.setOrderItems(orderItems);
        eOrder.addOrderItem(orderItem);
        eOrder.removeOrderItem(orderItem);
        assertEquals(0, eOrder.getOrderItems().size());
    }

    @Test
    public void updateOrderItem() {
        OrderItem orderItem = new OrderItem();
        eOrder.setOrderItems(orderItems);
        eOrder.addOrderItem(orderItem);
        OrderItem updatedOrderItem = new OrderItem();
        eOrder.updateOrderItem(orderItem, updatedOrderItem);
        assertEquals(updatedOrderItem, eOrder.getOrderItems().get(0));
    }

    @Test
    public void updateOrderItems() {
        OrderItem orderItem = new OrderItem();
        OrderItem updatedOrderItem = new OrderItem();
        eOrder.setOrderItems(orderItems);
        eOrder.addOrderItem(orderItem);
        List<OrderItem> updatedOrderItems = new ArrayList<>();
        updatedOrderItems.add(updatedOrderItem);
        eOrder.updateOrderItems(updatedOrderItems);
        assertEquals(updatedOrderItems, eOrder.getOrderItems());
    }

    @Test
    public void updateTotalAmount() {
        eOrder.setOrderItems(orderItems);
        OrderItem orderItem = new OrderItem();
        orderItem.setTotal(100.0);
        eOrder.addOrderItem(orderItem);
        eOrder.updateTotalAmount();
        assertEquals(100.0, eOrder.getTotalAmount(), 0.0);
    }

    @Test
    public void updateOrderDate() {
        eOrder.setOrderDate(LocalDateTime.now());
        eOrder.updateOrderDate();
        assertNotNull(eOrder.getOrderDate());
    }

    @Test
    public void updateStatus() {
        eOrder.setStatus(OrderStatus.PENDING.getStatus());
        eOrder.updateStatus(OrderStatus.PROCESSING.getStatus());
        assertEquals(OrderStatus.PROCESSING.getStatus(), eOrder.getStatus());
    }

    @Test
    public void testRemoveOrderItem() {
        OrderItem orderItem = new OrderItem();
        eOrder.setOrderItems(orderItems);
        eOrder.addOrderItem(orderItem);
        eOrder.removeOrderItem(orderItem);
        assertEquals(0, eOrder.getOrderItems().size());
    }

    @Test
    public void updateOrderItemTotal() {
        OrderItem orderItem = new OrderItem();
        orderItem.setTotal(100.0);
        eOrder.setOrderItems(orderItems);
        eOrder.addOrderItem(orderItem);
        eOrder.updateOrderItemTotal(orderItem, 200.0);
        assertEquals(200.0, eOrder.getOrderItems().get(0).getTotal(), 0.0);
    }

    @Test
    public void calculateTotal() {
        OrderItem orderItem = new OrderItem();
        orderItem.setTotal(100.0);
        eOrder.setOrderItems(orderItems);
        eOrder.addOrderItem(orderItem);
        assertEquals(100.0, eOrder.calculateTotal(), 0.0);
    }

    @Test
    public void testAddOrderItem() {
        // Update this method so that its implementation is not identical to "addOrderItem" on line 58
        eOrder.setOrderItems(orderItems);
        eOrder.addOrderItem(new OrderItem());
        assertEquals(1, eOrder.getOrderItems().size());
    }
}