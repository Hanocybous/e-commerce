package com.hanocybous.ecommercesystem.service.payment.paymentimpl;

import com.hanocybous.ecommercesystem.dto.payment.PaymentDto;
import com.hanocybous.ecommercesystem.entity.payment.Payment;
import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod;
import com.hanocybous.ecommercesystem.entity.payment.PaymentStatus;
import com.hanocybous.ecommercesystem.repository.payment.PaymentRepository;
import com.hanocybous.ecommercesystem.service.payment.IPaymentService;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@Getter
@SuppressWarnings("unused")
public class PaymentService implements IPaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Double getTotalAmountOfPayments() {
        Double paymentAmount = paymentRepository.getTotalAmountOfPayments();
        return paymentAmount == null ? 0 : paymentAmount;
    }

    public Double getTotalAmountOfPaymentsByPaymentMethod(String paymentMethod) {
        Double paymentAmount = paymentRepository.getTotalAmountOfPaymentsByPaymentMethod(paymentMethod);
        return paymentAmount == null ? 0 : paymentAmount;
    }

    public Double getTotalAmountOfPaymentsByPaymentStatus(String paymentStatus) {
        Double paymentAmount = paymentRepository.getTotalAmountOfPaymentsByPaymentStatus(paymentStatus);
        return paymentAmount == null ? 0 : paymentAmount;
    }

    public Double getTotalAmountOfPaymentsByPaymentMethodAndPaymentStatus(String paymentMethod,
                                                                          String paymentStatus) {
        Double paymentAmount =
                paymentRepository.getTotalAmountOfPaymentsByPaymentMethodAndPaymentStatus(
                        paymentMethod
                        , paymentStatus
                );
        return paymentAmount == null ? 0 : paymentAmount;
    }

    public Double getTotalAmountOfPaymentsByOrderId(Long orderId) {
        Double paymentAmount = paymentRepository.getTotalAmountOfPaymentsByOrderId(orderId);
        return paymentAmount == null ? 0 : paymentAmount;
    }

    public Payment createPayment(PaymentMethod paymentMethod,
                                 Double amount) {
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        return paymentRepository.save(payment);
    }

    public Payment createPayment(PaymentMethod paymentMethod,
                                 Double amount,
                                 Long orderId) {
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        payment.setOrderId(orderId);
        return paymentRepository.save(payment);
    }

    public Payment createPayment(PaymentMethod paymentMethod,
                                 Double amount,
                                 Long orderId,
                                 String paymentStatus) {
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        payment.setOrderId(orderId);
        payment.setPaymentStatus(PaymentStatus.valueOf(paymentStatus));
        return paymentRepository.save(payment);
    }

    public Payment createPayment(PaymentMethod paymentMethod,
                                 Double amount,
                                 String paymentStatus) {
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        payment.setPaymentStatus(PaymentStatus.valueOf(paymentStatus));
        return paymentRepository.save(payment);
    }

    @Override
    public List<PaymentDto> getPaymentById(Long paymentId) {
        for (int i = 0; i < paymentRepository.findAll().size(); i++) {
            Payment payment = paymentRepository.findAll().get(i);
            if (payment.getId().equals(paymentId)) {
                return paymentRepository.getPaymentById(paymentId);
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<PaymentDto> updatePayment(Payment payment) {
        for (int i = 0; i < paymentRepository.findAll().size(); i++) {
            Payment payment1 = paymentRepository.findAll().get(i);
            if (payment1.getId().equals(payment.getId())) {
                paymentRepository.save(payment);
                return paymentRepository.getPaymentById(payment.getId());
            }
        }
        return Collections.emptyList();
    }

    @Override
    public void deletePaymentById(Long paymentId) {
        for (int i = 0; i < paymentRepository.findAll().size(); i++) {
            Payment payment = paymentRepository.findAll().get(i);
            if (payment.getId().equals(paymentId)) {
                paymentRepository.delete(payment);
            }
        }
    }

    @Override
    public void deletePaymentByOrderId(Long orderId) {
        for (int i = 0; i < paymentRepository.findAll().size(); i++) {
            Payment payment = paymentRepository.findAll().get(i);
            if (payment.getOrderId().equals(orderId)) {
                paymentRepository.delete(payment);
            }
        }
    }

    @Override
    public void deletePaymentByPaymentMethod(PaymentMethod paymentMethod) {
        for (int i = 0; i < paymentRepository.findAll().size(); i++) {
            Payment payment = paymentRepository.findAll().get(i);
            if (payment.getPaymentMethod().equals(paymentMethod)) {
                paymentRepository.delete(payment);
            }
        }
    }

    public Payment createPayment(PaymentMethod paymentMethod,
                                 Double amount,
                                 String paymentStatus,
                                 String paymentDate) {
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        payment.setPaymentStatus(PaymentStatus.valueOf(paymentStatus));
        payment.setPaymentDate(LocalDateTime.parse(paymentDate));
        return paymentRepository.save(payment);
    }

    public Payment createPayment(PaymentMethod paymentMethod,
                                 Double amount,
                                 String paymentStatus,
                                 String paymentDate,
                                 Long orderId) {
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(amount);
        payment.setPaymentStatus(PaymentStatus.valueOf(paymentStatus));
        payment.setPaymentDate(LocalDateTime.parse(paymentDate));
        payment.setOrderId(orderId);
        return paymentRepository.save(payment);
    }

    public List<PaymentDto> getPaymentsSortedByPaymentDate() {
        return paymentRepository.getPaymentsSortedByPaymentDate();
    }

    public List<PaymentDto> getPaymentsSortedByPaymentDateByPaymentMethod(String paymentMethod) {
        return paymentRepository.getPaymentsSortedByPaymentDateByPaymentMethod(paymentMethod);
    }

    public List<PaymentDto> getPaymentsSortedByPaymentStatus() {
        return paymentRepository.getPaymentsSortedByPaymentStatus();
    }

    public List<PaymentDto> getPaymentsSortedByPaymentStatusByPaymentMethod(String paymentMethod) {
        return paymentRepository.getPaymentsSortedByPaymentStatusByPaymentMethod(paymentMethod);
    }

    public List<PaymentDto> getPaymentsSortedByPaymentMethod() {
        return paymentRepository.getPaymentsSortedByPaymentMethod();
    }

    public List<PaymentDto> getPaymentsSortedByOrderId() {
        return paymentRepository.getPaymentsSortedByOrderId();
    }

    public List<PaymentDto> getPaymentsSortedByOrderIdByPaymentMethod(String paymentMethod) {
        return paymentRepository.getPaymentsSortedByOrderIdByPaymentMethod(paymentMethod);
    }

    public List<PaymentDto> getPaymentsBetweenTwoDates(String startDate,
                                                       String endDate) {
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);
        return paymentRepository.getPaymentsBetweenTwoDates(startDateTime, endDateTime);
    }

    public List<PaymentDto> getPaymentsBetweenTwoDatesByPaymentMethod(String startDate,
                                                                      String endDate,
                                                                      String paymentMethod) {
        LocalDateTime startDateTime = LocalDateTime.parse(startDate);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate);
        return paymentRepository.getPaymentsBetweenTwoDatesByPaymentMethod(startDateTime, endDateTime, paymentMethod);
    }

    public List<PaymentDto> getPaymentByPaymentMethod(@NotNull String paymentMethod) {
        if (paymentMethod.equals("ALL")) {
            return paymentRepository.findAllPayments();
        }
        return paymentRepository.getPaymentByPaymentMethod(paymentMethod);
    }

    public List<PaymentDto> getPaymentByPaymentStatus(@NotNull String paymentStatus) {
        if (paymentStatus.equals("ALL") || paymentStatus.isEmpty()) {
            return paymentRepository.findAllPayments();
        }
        return paymentRepository.getPaymentByPaymentStatus(paymentStatus);
    }

    public List<PaymentDto> getPaymentByPaymentMethodAndPaymentStatus(@NotNull String paymentMethod,
                                                                      String paymentStatus) {
        if (paymentMethod.equals("ALL") &&
                paymentStatus.equals("ALL") ||
                paymentMethod.isEmpty() &&
                        paymentStatus.isEmpty()) {
            return paymentRepository.findAllPayments();
        }
        if (paymentMethod.equals(Objects.requireNonNull(PaymentStatus.fromString(paymentStatus)).toString())) {
            return paymentRepository.getPaymentByPaymentStatus(paymentStatus);
        }
        if (paymentStatus.equals(Objects.requireNonNull(PaymentMethod.getPaymentMethod(paymentMethod)).toString())) {
            return paymentRepository.getPaymentByPaymentMethod(paymentMethod);
        }
        return paymentRepository.getPaymentByPaymentMethodAndPaymentStatus(
                paymentMethod,
                paymentStatus);
    }

    public List<PaymentDto> getPaymentByOrderId(Long orderId) {
        if (orderId == null) {
            return paymentRepository.findAllPayments();
        }
        return paymentRepository.getPaymentByOrderId(orderId);
    }

    public void deletePaymentByPaymentStatus(@NotNull String paymentStatus) {
        if (paymentStatus.equals("ALL") || paymentStatus.isEmpty()) {
            paymentRepository.deleteAll();
        }
        paymentRepository.deletePaymentByPaymentStatus(paymentStatus);
    }

    public List<PaymentDto> findAllPayments() {
        return paymentRepository.findAllPayments();
    }

}
