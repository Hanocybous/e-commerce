package com.hanocybous.ecommercesystem.dto.payment

import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod
import com.hanocybous.ecommercesystem.entity.payment.PaymentStatus
import java.time.LocalDateTime

data class PaymentDto(
    val id: Long,
    val orderId: Long,
    val paymentDate: LocalDateTime,
    val paymentStatus: PaymentStatus,
    val paymentMethod: PaymentMethod,
    val amount: Double
) {

    init {
        require(id >= 0) { "ID cannot be negative" }
        require(orderId >= 0) { "Order ID cannot be negative" }
        require(!paymentDate.isAfter(LocalDateTime.now())) { "Payment date cannot be in the future" }
        require(amount >= 0) { "Amount cannot be negative" }
    }

    override fun toString(): String {
        return "PaymentDto(id=$id, " +
                "orderId=$orderId, " +
                "paymentDate=$paymentDate, " +
                "paymentStatus=$paymentStatus, " +
                "paymentMethod=$paymentMethod, " +
                "amount=$amount)"
    }
}
