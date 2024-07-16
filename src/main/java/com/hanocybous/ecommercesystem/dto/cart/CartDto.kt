package com.hanocybous.ecommercesystem.dto.cart

import com.hanocybous.ecommercesystem.entity.product.Product

data class CartDto(
    val id: Long?,
    val products: Collection<Product>,
    val userId: Long,
    val totalDiscount: Double,
    val totalShipping: Double,
    val totalPrice: Double,
    val totalAmount: Double
) {

    init {
        require(products.isNotEmpty()) { "Cart must have at least one product" }
    }

    override fun toString(): String {
        return "CartDto(id=$id, " +
                "products=$products, " +
                "userId=$userId, " +
                "totalDiscount=$totalDiscount, " +
                "totalShipping=$totalShipping, " +
                "totalPrice=$totalPrice, " +
                "totalAmount=$totalAmount)"
    }
}
