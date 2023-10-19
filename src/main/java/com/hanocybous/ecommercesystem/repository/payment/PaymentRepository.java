package com.hanocybous.ecommercesystem.repository;

import com.hanocybous.ecommercesystem.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
