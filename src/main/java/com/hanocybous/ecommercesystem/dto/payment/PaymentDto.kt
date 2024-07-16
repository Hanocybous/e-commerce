package com.hanocybous.ecommercesystem.dto.payment;

import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod;
import com.hanocybous.ecommercesystem.entity.payment.PaymentStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

public record PaymentDto(
        Long id,
        Long orderId,
        LocalDateTime paymentDate,
        PaymentStatus paymentStatus,
        PaymentMethod paymentMethod,
        Double amount
) {

    public PaymentDto {
        Objects.requireNonNull(id);
        Objects.requireNonNull(orderId);
        Objects.requireNonNull(paymentDate);
        Objects.requireNonNull(paymentStatus);
        Objects.requireNonNull(paymentMethod);
        Objects.requireNonNull(amount);

        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (orderId < 0) {
            throw new IllegalArgumentException("Order id cannot be negative");
        }
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be negative");
        }
        if (paymentDate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Payment date cannot be in the future");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", paymentDate=" + paymentDate +
                ", paymentStatus=" + paymentStatus +
                ", paymentMethod=" + paymentMethod +
                ", amount=" + amount +
                '}';
    }

}
