package com.hanocybous.ecommercesystem.entity.user;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public enum UserType {

    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN"),
    SELLER("SELLER");

    private final String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public static @Nullable UserType fromString(String userType) {
        for (UserType type : UserType.values()) {
            if (type.getUserType().equals(userType)) {
                return type;
            }
        }
        return null;
    }

}
