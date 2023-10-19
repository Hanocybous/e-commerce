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
public final class Admin extends User {

    private Long verificationCode;

    public Admin(String fullName,
                 String username,
                 String email,
                 String password,
                 Long verificationCode) {
        super(fullName, username, email, password);
        this.verificationCode = verificationCode;
    }

    @Override
    public UserType getRole() {
        return UserType.fromString("ADMIN");
    }

}
