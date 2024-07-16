package com.hanocybous.ecommercesystem.dto.user

import com.hanocybous.ecommercesystem.entity.user.UserType

data class UserDto(
    val id: Long?,
    val fullName: String,
    val username: String,
    val email: String,
    val password: String,
    val userType: UserType
) {

    init {
        require(fullName.isNotBlank()) { "Full name cannot be blank" }
        require(username.isNotBlank()) { "Username cannot be blank" }
        require(email.isNotBlank()) { "Email cannot be blank" }
        require(password.isNotBlank()) { "Password cannot be blank" }
    }

    override fun toString(): String {
        return "UserDto(id=$id, " +
                "fullName='$fullName', " +
                "username='$username', " +
                "email='$email', " +
                "password='$password', " +
                "userType=$userType)"
    }
}
