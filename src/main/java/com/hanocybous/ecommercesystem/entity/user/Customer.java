package com.hanocybous.ecommercesystem.entity.user;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
                    String password,
                    String address,
                    String phoneNumber,
                    String city,
                    String country,
                    String zipCode,
                    String state) {
        super(fullName, username, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.state = state;
    }

    @Override
    public UserType getRole() {
        return UserType.fromString("CUSTOMER");
    }

}
