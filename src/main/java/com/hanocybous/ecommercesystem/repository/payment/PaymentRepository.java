package com.hanocybous.ecommercesystem.repository.payment;

import com.hanocybous.ecommercesystem.dto.payment.PaymentDto;
import com.hanocybous.ecommercesystem.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // get the total amount of payments
    @Query(value =
            "SELECT SUM(amount) " +
            "FROM payment", nativeQuery = true
    )
    Double getTotalAmountOfPayments();

    // get the total amount of payments by payment method
    @Query(value =
            "SELECT SUM(amount) " +
            "FROM payment " +
            "WHERE payment_method = ?1", nativeQuery = true
    )
    Double getTotalAmountOfPaymentsByPaymentMethod(@Param("paymentMethod") String paymentMethod);

    // get the total amount of payments by payment status
    @Query(value =
            "SELECT SUM(amount) " +
            "FROM payment " +
            "WHERE payment_status = ?1", nativeQuery = true
    )
    Double getTotalAmountOfPaymentsByPaymentStatus(@Param("paymentStatus") String paymentStatus);

    // get the total amount of payments by payment method and payment status
    @Query(value =
            "SELECT SUM(amount) " +
            "FROM payment " +
            "WHERE payment_method = ?1 " +
            "AND payment_status = ?2", nativeQuery = true
    )
    Double getTotalAmountOfPaymentsByPaymentMethodAndPaymentStatus(@Param("paymentMethod") String paymentMethod,
                                                                   @Param("paymentStatus") String paymentStatus);

    // get the total amount of payments by order id
    @Query(value =
            "SELECT SUM(amount) " +
            "FROM payment " +
            "WHERE order_id = ?1", nativeQuery = true
    )
    Double getTotalAmountOfPaymentsByOrderId(@Param("orderId") Long orderId);

    // get the payments sorted by payment date
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "ORDER BY payment_date", nativeQuery = true
    )
    List<PaymentDto> getPaymentsSortedByPaymentDate();

    // get the payments sorted by payment date by payment method
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_method = ?1 " +
            "ORDER BY payment_date", nativeQuery = true
    )
    List<PaymentDto> getPaymentsSortedByPaymentDateByPaymentMethod(@Param("paymentMethod") String paymentMethod);

    // get the payments sorted by payment status
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "ORDER BY payment_status", nativeQuery = true
    )
    List<PaymentDto> getPaymentsSortedByPaymentStatus();

    // get the payments sorted by payment status by payment method
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_method = ?1 " +
            "ORDER BY payment_status", nativeQuery = true
    )
    List<PaymentDto> getPaymentsSortedByPaymentStatusByPaymentMethod(@Param("paymentMethod") String paymentMethod);

    // get the payments sorted by payment method
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "ORDER BY payment_method", nativeQuery = true
    )
    List<PaymentDto> getPaymentsSortedByPaymentMethod();

    // get the payments sorted by order id
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "ORDER BY order_id", nativeQuery = true
    )
    List<PaymentDto> getPaymentsSortedByOrderId();

    // get the payments sorted by order id by payment method
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_method = ?1 " +
            "ORDER BY order_id", nativeQuery = true
    )
    List<PaymentDto> getPaymentsSortedByOrderIdByPaymentMethod(@Param("paymentMethod") String paymentMethod);

    // get the payments between two dates
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_date BETWEEN ?1 AND ?2", nativeQuery = true
    )
    List<PaymentDto> getPaymentsBetweenTwoDates(@Param("startDate") LocalDateTime startDate,
                                                @Param("endDate") LocalDateTime endDate);


    // get the payments between two dates by payment method
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_date BETWEEN ?1 AND ?2 " +
            "AND payment_method = ?3", nativeQuery = true
    )
    List<PaymentDto> getPaymentsBetweenTwoDatesByPaymentMethod(@Param("startDate") LocalDateTime startDate,
                                                               @Param("endDate") LocalDateTime endDate,
                                                               @Param("paymentMethod") String paymentMethod);


    // get payment by id
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_id = ?1", nativeQuery = true
    )
    List<PaymentDto> getPaymentById(Long paymentId);

    // get payment by payment method
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_method = ?1", nativeQuery = true
    )
    List<PaymentDto> getPaymentByPaymentMethod(String paymentMethod);

    // get payment by payment status
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_status = ?1", nativeQuery = true
    )
    List<PaymentDto> getPaymentByPaymentStatus(String paymentStatus);

    // get all payments
    @Query(value =
            "SELECT * " +
            "FROM payment", nativeQuery = true
    )
    List<PaymentDto> findAllPayments();

    // get payment by payment method and payment status
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE payment_method = ?1 " +
            "AND payment_status = ?2", nativeQuery = true
    )
    List<PaymentDto> getPaymentByPaymentMethodAndPaymentStatus(String paymentMethod, String paymentStatus);

    // get payment by order id
    @Query(value =
            "SELECT * " +
            "FROM payment " +
            "WHERE order_id = ?1", nativeQuery = true
    )
    List<PaymentDto> getPaymentByOrderId(Long orderId);

    // delete payment by id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM payment " +
            "WHERE payment_id = ?1", nativeQuery = true
    )
    void deletePaymentById(Long paymentId);

    // delete payment by payment method
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM payment " +
            "WHERE payment_method = ?1", nativeQuery = true
    )
    void deletePaymentByPaymentStatus(String paymentStatus);

}
