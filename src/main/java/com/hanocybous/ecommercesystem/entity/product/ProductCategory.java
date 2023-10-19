package com.hanocybous.ecommercesystem.entity.product;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public enum ProductCategory {

    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    BOOKS("Books"),
    SPORTS("Sports"),
    HOME("Home"),
    GARDEN("Garden"),
    BEAUTY("Beauty"),
    HEALTH("Health"),
    TOYS("Toys"),
    AUTOMOTIVE("Automotive"),
    OTHER("Other");

    private final String name;

    ProductCategory(String name) {
        this.name = name;
    }

    public static @Nullable ProductCategory fromString(String text) {
        for (ProductCategory category : ProductCategory.values()) {
            if (category.name.equalsIgnoreCase(text)) {
                return category;
            }
        }
        return null;
    }

}
