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
public final class Seller extends User {

    private String companyName;
    private String companyAddress;
    private String companyPhoneNumber;

    public Seller(String fullName,
                  String username,
                  String email,
                  String password,
                  String companyName,
                  String companyAddress,
                  String companyPhoneNumber) {
        super(fullName, username, email, password);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public Seller(String fullName,
                  String username,
                  String email,
                  String password,
                  String companyName) {
        super(fullName, username, email, password);
        this.companyName = companyName;
    }

    @Override
    public UserType getRole() {
        return UserType.fromString("SELLER");
    }

}
