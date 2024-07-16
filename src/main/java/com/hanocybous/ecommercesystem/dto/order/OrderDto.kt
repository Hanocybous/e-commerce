package com.hanocybous.ecommercesystem.dto.order

import com.hanocybous.ecommercesystem.entity.order.EOrder
import com.hanocybous.ecommercesystem.entity.order.OrderItem
import com.hanocybous.ecommercesystem.entity.order.OrderStatus
import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod
import java.time.LocalDateTime

data class OrderDto(
    val id: Long,
    val orderItems: List<OrderItem>,
    val orderDate: LocalDateTime,
    val status: OrderStatus,
    val shippingAddress: String,
    val paymentMethod: PaymentMethod,
    val totalAmount: Double
) {

    init {
        require(orderItems.isNotEmpty()) { "Order items cannot be empty" }
        require(shippingAddress.isNotBlank()) { "Shipping address cannot be blank" }
        require(totalAmount >= 0) { "Total amount cannot be negative" }
        require(!orderDate.isAfter(LocalDateTime.now())) { "Order date cannot be in the future" }
    }

    override fun toString(): String {
        return "OrderDto(id=$id, " +
                "orderItems=$orderItems, " +
                "orderDate=$orderDate, " +
                "status=$status, " +
                "shippingAddress='$shippingAddress', " +
                "paymentMethod='$paymentMethod', " +
                "totalAmount=$totalAmount)"
    }

    fun toOrder(): EOrder {
        return EOrder(
            id,
            orderItems,
            orderDate,
            status,
            shippingAddress,
            paymentMethod,
            totalAmount
        )
    }
}
