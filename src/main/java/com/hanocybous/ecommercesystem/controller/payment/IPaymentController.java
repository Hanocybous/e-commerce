package com.hanocybous.ecommercesystem.controller.payment;

import com.hanocybous.ecommercesystem.dto.payment.PaymentDto;

import java.util.List;

public interface IPaymentController {

    Double getTotalAmountOfPayments(String paymentMethod, String paymentStatus);


    Double createPayment(String paymentMethod, Double amount, Long orderId);


    List<PaymentDto> getPaymentById(Long paymentId);


    List<PaymentDto> getPaymentByPaymentMethod(String paymentMethod);


    void deletePaymentById(Long paymentId);

    void deletePaymentByPaymentMethod(String paymentMethod);

    void deletePaymentByPaymentStatus(String paymentStatus);

    List<PaymentDto> getAllPayments();

}
