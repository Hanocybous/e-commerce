package com.hanocybous.ecommercesystem.entity.payment;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public enum PaymentMethod {

    CREDIT_CARD("CREDIT_CARD"),
    DEBIT_CARD("DEBIT_CARD"),
    PAYPAL("PAYPAL"),
    CASH_ON_DELIVERY("CASH_ON_DELIVERY");

    private final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public static @Nullable PaymentMethod getPaymentMethod(String paymentMethod) {
        for (PaymentMethod method : PaymentMethod.values()) {
            if (method.getPaymentMethod().equals(paymentMethod)) {
                return method;
            }
        }
        return null;
    }

    public static @Nullable PaymentMethod getPaymentMethod(int paymentMethod) {
        for (PaymentMethod method : PaymentMethod.values()) {
            if (method.ordinal() == paymentMethod) {
                return method;
            }
        }
        return null;
    }

    public static @Nullable String getPaymentMethodFromPaymentMethod(PaymentMethod paymentMethod) {
        for (PaymentMethod method : PaymentMethod.values()) {
            if (method.equals(paymentMethod)) {
                return method.getPaymentMethod();
            }
        }
        return null;
    }

}
