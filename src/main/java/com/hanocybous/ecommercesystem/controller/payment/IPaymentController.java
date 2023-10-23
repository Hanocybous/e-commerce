package com.hanocybous.ecommercesystem.controller.payment;

import com.hanocybous.ecommercesystem.dto.payment.PaymentDto;

import java.util.List;

public interface IPaymentController {

    Double getTotalAmountOfPayments(String paymentMethod, String paymentStatus);

    Double getTotalAmountOfPaymentsByOrderId(Long orderId);

    Double createPayment(String paymentMethod, Double amount);

    Double createPayment(String paymentMethod, Double amount, Long orderId);

    Double createPayment(String paymentMethod, Double amount, Long orderId, String paymentStatus);

    List<PaymentDto> getPaymentById(Long paymentId);

    List<PaymentDto> getPaymentByOrderId(Long orderId);

    List<PaymentDto> getPaymentByPaymentMethod(String paymentMethod);

    List<PaymentDto> getPaymentByPaymentStatus(String paymentStatus);

    void deletePaymentById(Long paymentId);

    void deletePaymentByPaymentMethod(String paymentMethod);

    void deletePaymentByPaymentStatus(String paymentStatus);

    List<PaymentDto> getAllPayments();

}
