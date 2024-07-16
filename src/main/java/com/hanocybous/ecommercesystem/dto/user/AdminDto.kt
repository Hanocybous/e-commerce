package com.hanocybous.ecommercesystem.dto.user

data class AdminDto(
    val id: Long,
    val fullName: String,
    val username: String,
    val email: String,
    val password: String,
    val verificationCode: Long
) {

    init {
        require(fullName.isNotBlank()) { "Full name cannot be blank" }
        require(username.isNotBlank()) { "Username cannot be blank" }
        require(email.isNotBlank()) { "Email cannot be blank" }
        require(password.isNotBlank()) { "Password cannot be blank" }
    }

}
