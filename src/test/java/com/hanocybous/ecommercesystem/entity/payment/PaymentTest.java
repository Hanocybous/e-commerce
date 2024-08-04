package com.hanocybous.ecommercesystem.entity.payment;

import com.hanocybous.ecommercesystem.entity.order.EOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@FixMethodOrder(value = org.junit.runners.MethodSorters.NAME_ASCENDING)
public class PaymentTest {

    private Payment payment;
    private EOrder eOrder;

    @Before
    public void setUp() {
        eOrder = new EOrder();
        payment = new Payment(eOrder, PaymentMethod.CREDIT_CARD, 100.0);
    }

    @After
    public void tearDown() {
        eOrder = null;
        payment = null;
    }

    @Test
    public void getOrderId() {
        assertNull(payment.getOrderId());
    }

    @Test
    public void setOrderId() {
        payment.setOrderId(1L);
        assertEquals(1L, payment.getOrderId().longValue());
    }

    @Test
    public void getOrderTotalAmount() {
        payment.setOrderTotalAmount(200.0);
        assertEquals(200.0, payment.getOrderTotalAmount(), 0.0);
    }
}