package com.hanocybous.ecommercesystem.entity.cart;

import com.hanocybous.ecommercesystem.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "cart_id")
    private Collection<Product> products;
    private Long userId;
    private Double totalPrice;
    private Double totalDiscount;
    private Double totalShipping;
    private Double totalAmount;

    public Cart(Collection<Product> products) {
        this.products = products;
    }

    public void addProduct(@NotNull Product product) {
        if (products.contains(product)) {
            products.stream()
                    .filter(p -> p.equals(product))
                    .findFirst()
                    .get()
                    .setQuantity(product.getQuantity() + 1);
        } else {
            products.add(product);
        }
    }

    public void removeProduct(@NotNull Product product) {
        if (products.contains(product)) {
            products.stream()
                    .filter(p -> p.equals(product))
                    .findFirst()
                    .get()
                    .setQuantity(product.getQuantity() - 1);
        } else {
            products.remove(product);
        }
    }

    public void clearCart() {
        products.clear();
    }

    private double calculateTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private double calculateTotalDiscount() {
        return products.stream()
                .mapToDouble(Product::getTotalDiscount)
                .sum();
    }

    private double calculateTotalTax() {
        return products.stream()
                .mapToDouble(Product::getTotalTax)
                .sum();
    }

    public void calculateTotalAmount() {
        totalAmount =
                calculateTotalPrice()
                + calculateTotalDiscount()
                + calculateTotalTax();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                ", totalDiscount=" + totalDiscount +
                ", totalShipping=" + totalShipping +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (products.size() != cart.products.size()) return false;

        Iterator<Product> iterator = products.iterator();
        Iterator<Product> iterator1 = cart.products.iterator();

        while (iterator.hasNext() && iterator1.hasNext()) {
            Product product = iterator.next();
            Product product1 = iterator1.next();
            if (!product.equals(product1)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return products.hashCode();
    }

}
