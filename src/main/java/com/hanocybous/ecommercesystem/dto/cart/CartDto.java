package com.hanocybous.ecommercesystem.dto.cart;

import com.hanocybous.ecommercesystem.entity.product.Product;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

public record CartDto(
        Long id,
        Collection<Product> products,
        Long userId,
        Double totalDiscount,
        Double totalShipping,
        Double totalPrice,
        Double totalAmount
) {

    public CartDto {
        Objects.requireNonNull(products);
        Objects.requireNonNull(userId);
        Objects.requireNonNull(totalDiscount);
        Objects.requireNonNull(totalShipping);
        Objects.requireNonNull(totalPrice);
        Objects.requireNonNull(totalAmount);

        if (products.isEmpty()) {
            throw new IllegalArgumentException("Cart must have at least one product");
        }
        if (totalDiscount < 0) {
            throw new IllegalArgumentException("Total discount must be greater than or equal to 0");
        }
        if (totalShipping < 0) {
            throw new IllegalArgumentException("Total shipping must be greater than or equal to 0");
        }
        if (totalPrice < 0) {
            throw new IllegalArgumentException("Total price must be greater than or equal to 0");
        }
        if (totalAmount < 0) {
            throw new IllegalArgumentException("Total amount must be greater than or equal to 0");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "CartDto{" +
                "id=" + id +
                ", products=" + products +
                ", userId=" + userId +
                ", totalDiscount=" + totalDiscount +
                ", totalShipping=" + totalShipping +
                ", totalPrice=" + totalPrice +
                ", totalAmount=" + totalAmount +
                '}';
    }

}
