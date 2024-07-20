package com.hanocybous.ecommercesystem.dto.order

data class OrderItemDto(
    val id: Long,
    val productId: Long,
    val orderId: Long,
    val productName: String,
    val productPrice: Double,
    val quantity: Int,
    val totalAmount: Double
) {

    init {
        require(id >= 0) { "id cannot be negative" }
        require(productId >= 0) { "productId cannot be negative" }
        require(orderId >= 0) { "orderId cannot be negative" }
        require(productName.isNotBlank()) { "productName cannot be blank" }
        require(productPrice >= 0) { "productPrice cannot be negative" }
        require(quantity >= 0) { "quantity cannot be negative" }
        require(totalAmount >= 0) { "totalAmount cannot be negative" }
    }

}
