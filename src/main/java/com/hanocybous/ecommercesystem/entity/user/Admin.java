package com.hanocybous.ecommercesystem.entity.user;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "Admin{" +
                "verificationCode=" + verificationCode +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Admin admin) {
            return admin.getFullName().equals(this.getFullName()) &&
                    admin.getUsername().equals(this.getUsername()) &&
                    admin.getEmail().equals(this.getEmail()) &&
                    admin.getPassword().equals(this.getPassword()) &&
                    admin.getVerificationCode().equals(this.getVerificationCode());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 69;
        result = 31 * result + this.getFullName().hashCode();
        result = 31 * result + this.getUsername().hashCode();
        result = 31 * result + this.getEmail().hashCode();
        result = 31 * result + this.getPassword().hashCode();
        result = 31 * result + this.getVerificationCode().hashCode();
        return result;
    }

    @Override
    public boolean canEqual(Object obj) {
        return obj instanceof Admin;
    }

}
