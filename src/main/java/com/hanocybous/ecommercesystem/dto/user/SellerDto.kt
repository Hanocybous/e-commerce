package com.hanocybous.ecommercesystem.dto.user

data class SellerDto(
    val id: Long?,
    val fullName: String,
    val username: String,
    val email: String,
    val password: String,
    val companyName: String,
    val companyAddress: String,
    val companyPhoneNumber: String
) {

    init {
        require(fullName.isNotBlank()) { "Full name cannot be blank" }
        require(username.isNotBlank()) { "Username cannot be blank" }
        require(email.isNotBlank()) { "Email cannot be blank" }
        require(password.isNotBlank()) { "Password cannot be blank" }
        require(companyName.isNotBlank()) { "Company name cannot be blank" }
        require(companyAddress.isNotBlank()) { "Company address cannot be blank" }
        require(companyPhoneNumber.isNotBlank()) { "Company phone number cannot be blank" }
    }

    override fun toString(): String {
        return "SellerDto(id=$id, " +
                "fullName='$fullName', " +
                "username='$username', " +
                "email='$email', " +
                "password='$password', " +
                "companyName='$companyName', " +
                "companyAddress='$companyAddress', " +
                "companyPhoneNumber='$companyPhoneNumber')"
    }
}
