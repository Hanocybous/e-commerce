package com.hanocybous.ecommercesystem.dto.user

data class CustomerDto(
    val id: Long,
    val fullName: String,
    val username: String,
    val email: String,
    val password: String,
    val address: String,
    val phoneNumber: String,
    val city: String,
    val country: String,
    val zipCode: String,
    val state: String
) {

    init {
        require(fullName.isNotBlank()) { "Full name cannot be blank" }
        require(username.isNotBlank()) { "Username cannot be blank" }
        require(email.isNotBlank()) { "Email cannot be blank" }
        require(password.isNotBlank()) { "Password cannot be blank" }
        require(address.isNotBlank()) { "Address cannot be blank" }
        require(phoneNumber.isNotBlank()) { "Phone number cannot be blank" }
        require(city.isNotBlank()) { "City cannot be blank" }
        require(country.isNotBlank()) { "Country cannot be blank" }
        require(zipCode.isNotBlank()) { "Zip code cannot be blank" }
        require(state.isNotBlank()) { "State cannot be blank" }
    }

}
