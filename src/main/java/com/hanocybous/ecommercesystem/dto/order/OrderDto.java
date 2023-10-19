package com.hanocybous.ecommercesystem.dto.order;

import com.hanocybous.ecommercesystem.entity.order.Order;
import com.hanocybous.ecommercesystem.entity.order.OrderItem;
import com.hanocybous.ecommercesystem.entity.order.OrderStatus;
import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public record OrderDto(
        Long id,
        List<OrderItem> orderItems,
        LocalDateTime orderDate,
        OrderStatus status,
        String shippingAddress,
        PaymentMethod paymentMethod,
        Double totalAmount
) {

    public OrderDto {
        Objects.requireNonNull(id);
        Objects.requireNonNull(orderItems);
        Objects.requireNonNull(orderDate);
        Objects.requireNonNull(status);
        Objects.requireNonNull(shippingAddress);
        Objects.requireNonNull(paymentMethod);
        Objects.requireNonNull(totalAmount);

        if (totalAmount < 0) {
            throw new IllegalArgumentException("Total amount cannot be negative");
        }
        if (orderItems.isEmpty()) {
            throw new IllegalArgumentException("Order items cannot be empty");
        }
        if (shippingAddress.isBlank()) {
            throw new IllegalArgumentException("Shipping address cannot be blank");
        }
        if (orderDate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Order date cannot be in the future");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "Order{" +
                "id=" + id +
                ", orderItems=" + orderItems +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Contract(" -> new")
    public @NotNull Order toOrder() {
        return new Order(
                id,
                orderItems,
                orderDate,
                status,
                shippingAddress,
                paymentMethod,
                totalAmount
        );
    }

}
