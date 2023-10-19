package com.hanocybous.ecommercesystem.dto.order;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record OrderItemDto(
        Long id,
        Long productId,
        Long orderId,
        String productName,
        Double productPrice,
        Integer quantity,
        Double totalAmount
) {

    public OrderItemDto {
        Objects.requireNonNull(id);
        Objects.requireNonNull(productId);
        Objects.requireNonNull(orderId);
        Objects.requireNonNull(productName);
        Objects.requireNonNull(productPrice);
        Objects.requireNonNull(quantity);
        Objects.requireNonNull(totalAmount);

        if (id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        }
        if (productId < 0) {
            throw new IllegalArgumentException("productId cannot be negative");
        }
        if (orderId < 0) {
            throw new IllegalArgumentException("orderId cannot be negative");
        }
        if (productName.isBlank()) {
            throw new IllegalArgumentException("productName cannot be blank");
        }
        if (productPrice < 0) {
            throw new IllegalArgumentException("productPrice cannot be negative");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        if (totalAmount < 0) {
            throw new IllegalArgumentException("totalAmount cannot be negative");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "OrderItemDto{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}';
    }

}
