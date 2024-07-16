package com.hanocybous.ecommercesystem.dto.product

data class ProductDto(
    val id: Long,
    val name: String,
    val price: Double,
    val category: String,
    val quantity: Int
) {

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(price >= 0) { "Price cannot be negative" }
        require(category.isNotBlank()) { "Category cannot be blank" }
        require(quantity >= 0) { "Quantity cannot be negative" }
    }

    override fun toString(): String {
        return "ProductDto(id=$id, " +
                "name='$name', " +
                "price=$price, " +
                "category='$category', " +
                "quantity=$quantity)"
    }
}
