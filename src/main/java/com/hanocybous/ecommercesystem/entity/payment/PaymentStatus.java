package com.hanocybous.ecommercesystem.entity.payment;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public enum PaymentStatus {

    PENDING("PENDING"),
    PAID("PAID"),
    CANCELLED("CANCELLED");

    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public static @Nullable PaymentStatus fromString(String status) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (paymentStatus.getStatus().equalsIgnoreCase(status)) {
                return paymentStatus;
            }
        }
        return null;
    }

}
