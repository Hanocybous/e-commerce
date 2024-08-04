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

    @Override
    public @NotNull String toString() {
        return "Seller(companyName=" + this.getCompanyName() +
                ", companyAddress=" + this.getCompanyAddress() +
                ", companyPhoneNumber=" + this.getCompanyPhoneNumber() +
                ", fullName=" + this.getFullName() +
                ", username=" + this.getUsername() +
                ", email=" + this.getEmail() +
                ", password=" + this.getPassword() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Seller other)) return false;

        return getCompanyAddress().equals(other.getCompanyAddress()) &&
                getCompanyPhoneNumber().equals(other.getCompanyPhoneNumber()) &&
                getCompanyName().equals(other.getCompanyName()) &&
                getFullName().equals(other.getFullName()) &&
                getUsername().equals(other.getUsername()) &&
                getEmail().equals(other.getEmail()) &&
                getPassword().equals(other.getPassword());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + getCompanyAddress().hashCode();
        result = result * 59 + getCompanyPhoneNumber().hashCode();
        result = result * 59 + getCompanyName().hashCode();
        result = result * 59 + getFullName().hashCode();
        result = result * 59 + getUsername().hashCode();
        result = result * 59 + getEmail().hashCode();
        result = result * 59 + getPassword().hashCode();
        return result;
    }

    @Override
    public boolean canEqual(Object obj) {
        return obj instanceof Seller;
    }

}
