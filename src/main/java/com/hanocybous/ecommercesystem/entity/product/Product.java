package com.hanocybous.ecommercesystem.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Transient
    private String description;
    private double price;
    private String category;
    @Transient
    private String image;
    private int quantity;
    @Transient
    private double totalPrice;
    @Transient
    private double totalDiscount;
    @Transient
    private double totalTax;
    @Transient
    private double totalAmount;

    public Product(String name,
                   double price,
                   String category,
                   int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public Product(String name,
                   String description,
                   double price,
                   String category,
                   String image,
                   int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
        this.quantity = quantity;
    }

    public Product(String name,
                   double price,
                   int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(Long id,
                   String name,
                   double price,
                   int quantity,
                   double totalDiscount,
                   double totalTax,
                   String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalDiscount = totalDiscount;
        this.totalTax = totalTax;
        this.description = description;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        } else {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
    }

    public void increaseQuantity() {
        quantity++;
    }

    public double getTotalPriceByQuantity() {
        return price * quantity;
    }

    public void checkCategory(String category) {
        ProductCategory productCategory = ProductCategory.fromString(category);
        if (productCategory == null) {
            throw new IllegalArgumentException("Invalid category");
        }
        setCategory(category);
    }

    public double calculateTotalPrice() {
        return
                (getPrice() * getQuantity())
                        - getTotalDiscount()
                        + getTotalTax();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name +
                ", description='" + description +
                ", price=" + price +
                ", category='" + category +
                ", image='" + image +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", totalDiscount=" + totalDiscount +
                ", totalTax=" + totalTax +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Product.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

}
