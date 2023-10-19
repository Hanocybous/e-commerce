package com.hanocybous.ecommercesystem.dto.user;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public record CustomerDto(
        Long id,
        String fullName,
        String username,
        String email,
        String password,
        String address,
        String phoneNumber,
        String city,
        String country,
        String zipCode,
        String state
) {

    public CustomerDto {
        Objects.requireNonNull(id);
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(username);
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        Objects.requireNonNull(address);
        Objects.requireNonNull(phoneNumber);
        Objects.requireNonNull(city);
        Objects.requireNonNull(country);
        Objects.requireNonNull(zipCode);
        Objects.requireNonNull(state);

        if (fullName.isBlank()) {
            throw new IllegalArgumentException("fullName is blank");
        }

        if (username.isBlank()) {
            throw new IllegalArgumentException("username is blank");
        }

        if (email.isBlank()) {
            throw new IllegalArgumentException("email is blank");
        }

        if (password.isBlank()) {
            throw new IllegalArgumentException("password is blank");
        }

        if (address.isBlank()) {
            throw new IllegalArgumentException("address is blank");
        }

        if (phoneNumber.isBlank()) {
            throw new IllegalArgumentException("phoneNumber is blank");
        }

        if (city.isBlank()) {
            throw new IllegalArgumentException("city is blank");
        }

        if (country.isBlank()) {
            throw new IllegalArgumentException("country is blank");
        }

        if (zipCode.isBlank()) {
            throw new IllegalArgumentException("zipCode is blank");
        }

        if (state.isBlank()) {
            throw new IllegalArgumentException("state is blank");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

}
