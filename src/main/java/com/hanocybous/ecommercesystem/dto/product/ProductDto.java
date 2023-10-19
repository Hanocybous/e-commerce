package com.hanocybous.ecommercesystem.dto;

import java.util.Objects;

public record ProductDto(
        Long id,
        String name,
        double price,
        String category,
        int quantity
) {

    public ProductDto {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(price);
        Objects.requireNonNull(category);
        Objects.requireNonNull(quantity);

        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (category.isBlank()) {
            throw new IllegalArgumentException("Category cannot be blank");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
