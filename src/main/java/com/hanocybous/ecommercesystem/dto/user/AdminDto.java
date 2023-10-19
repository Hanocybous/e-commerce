package com.hanocybous.ecommercesystem.dto.user;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record AdminDto(
        Long id,
        String fullName,
        String username,
        String email,
        String password,
        Long verificationCode
) {

    public AdminDto {
        Objects.requireNonNull(id);
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(username);
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        Objects.requireNonNull(verificationCode);

        if (fullName.isBlank()) {
            throw new IllegalArgumentException("fullName cannot be blank");
        }
        if (username.isBlank()) {
            throw new IllegalArgumentException("username cannot be blank");
        }
        if (email.isBlank()) {
            throw new IllegalArgumentException("email cannot be blank");
        }
        if (password.isBlank()) {
            throw new IllegalArgumentException("password cannot be blank");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "AdminDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", verificationCode=" + verificationCode +
                '}';
    }

}
