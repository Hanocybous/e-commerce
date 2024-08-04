package com.hanocybous.ecommercesystem.entity.order;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public enum OrderStatus {

    PENDING("Pending"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    private final String displayValue;

    OrderStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public static @Nullable OrderStatus fromString(String text) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.displayValue.equalsIgnoreCase(text)) {
                return orderStatus;
            }
        }
        return null;
    }

    public OrderStatus getStatus() {
        return this;
    }
}
