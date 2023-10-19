package com.hanocybous.ecommercesystem.service.payment;

import com.hanocybous.ecommercesystem.dto.payment.PaymentDto;
import com.hanocybous.ecommercesystem.entity.payment.Payment;
import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod;

import java.util.List;

public interface IPaymentService {

    Double getTotalAmountOfPayments();

    Double getTotalAmountOfPaymentsByPaymentMethod(String paymentMethod);

    Double getTotalAmountOfPaymentsByPaymentStatus(String paymentStatus);

    Double getTotalAmountOfPaymentsByPaymentMethodAndPaymentStatus(String paymentMethod,
                                                                  String paymentStatus);

    Double getTotalAmountOfPaymentsByOrderId(Long orderId);

    Payment createPayment(PaymentMethod paymentMethod,
                          Double amount);

    Payment createPayment(PaymentMethod paymentMethod,
                          Double amount,
                          Long orderId);

    Payment createPayment(PaymentMethod paymentMethod,
                            Double amount,
                            Long orderId,
                            String paymentStatus);

    Payment createPayment(PaymentMethod paymentMethod,
                            Double amount,
                            String paymentStatus);

    List<PaymentDto> getPaymentById(Long paymentId);

    List<PaymentDto> updatePayment(Payment payment);

    void deletePaymentById(Long paymentId);

    void deletePaymentByOrderId(Long orderId);

    void deletePaymentByPaymentMethod(PaymentMethod paymentMethod);

}
