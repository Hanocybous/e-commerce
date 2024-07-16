package com.hanocybous.ecommercesystem.dto.user;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record SellerDto(
        Long id,
        String fullName,
        String username,
        String email,
        String password,
        String companyName,
        String companyAddress,
        String companyPhoneNumber
) {

    public SellerDto {
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(username);
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        Objects.requireNonNull(companyName);
        Objects.requireNonNull(companyAddress);
        Objects.requireNonNull(companyPhoneNumber);

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
        if (companyName.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be blank");
        }
        if (companyAddress.isBlank()) {
            throw new IllegalArgumentException("Company address cannot be blank");
        }
        if (companyPhoneNumber.isBlank()) {
            throw new IllegalArgumentException("Company phone number cannot be blank");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "SellerDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyPhoneNumber='" + companyPhoneNumber + '\'' +
                '}';
    }

}
