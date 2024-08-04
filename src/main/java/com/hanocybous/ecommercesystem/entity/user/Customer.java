package com.hanocybous.ecommercesystem.entity.user;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Customer extends User {

    private String address;
    private String phoneNumber;
    private String city;
    private String country;
    private String zipCode;
    private String state;

    public Customer(String fullName,
                    String username,
                    String email,
                    String password) {
        super(fullName, username, email, password);
    }

    @Override
    public UserType getRole() {
        return UserType.fromString("CUSTOMER");
    }

    @Override
    public @NotNull String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state='" + state + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer customer)) return false;

        return getAddress().equals(customer.getAddress()) &&
                getPhoneNumber().equals(customer.getPhoneNumber()) &&
                getCity().equals(customer.getCity()) &&
                getCountry().equals(customer.getCountry()) &&
                getZipCode().equals(customer.getZipCode()) &&
                getState().equals(customer.getState());
    }

    @Override
    public int hashCode() {
        int result = 31;
        result += getAddress().hashCode();
        result += getPhoneNumber().hashCode();
        result += getCity().hashCode();
        result += getCountry().hashCode();
        result += getZipCode().hashCode();
        result += getState().hashCode();
        return result;
    }

    @Override
    public boolean canEqual(Object obj) {
        return obj instanceof Customer;
    }

}
