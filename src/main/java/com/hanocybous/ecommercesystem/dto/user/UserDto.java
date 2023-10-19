package com.hanocybous.ecommercesystem.dto;

import com.hanocybous.ecommercesystem.entity.user.UserType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record UserDto(
        Long id,
        String fullName,
        String username,
        String email,
        String password,
        UserType userType
) {

    public UserDto {
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(username);
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        Objects.requireNonNull(userType);

        if (fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be blank");
        }
        if (username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank");
        }
        if (email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        if (password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be blank");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "UserDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }

}
