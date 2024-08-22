package com.hanocybous.ecommercesystem.entity.cart;

import com.hanocybous.ecommercesystem.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @OneToMany
    @JoinColumn(name = "cart_id")
    private List<Product> products;
    @Setter
    @Getter
    private Long userId;
    private Double totalPrice;
    private Double totalDiscount;
    private Double totalShipping;
    private Double totalAmount;
    private Long productId;

    public Cart(Long id, List<Product> products, Long userId, Double totalPrice, Double totalDiscount, Double totalShipping, Double totalAmount) {
        this.id = id;
        this.products = products;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalShipping = totalShipping;
        this.totalAmount = totalAmount;
    }

    public Cart(Long id, List<Product> products, Long userId, Double totalPrice, Double totalDiscount, Double totalShipping) {
        this.id = id;
        this.products = products;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalShipping = totalShipping;
    }

    public Cart(Long id, List<Product> products, Long userId, Double totalPrice, Double totalDiscount) {
        this.id = id;
        this.products = products;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
    }

    public Cart(Long id, List<Product> products, Long userId, Double totalPrice) {
        this.id = id;
        this.products = products;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public Cart(List<Product> products) {
        this.products = products;
    }

    public <E> Cart(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public void addProduct(@NotNull Product product) {
        // Check for null list
        if (products != null) {
            products.add(product);
        }
        else {
            throw new NullPointerException("Product list is null");
        }
    }

    public void removeProduct(@NotNull Product product) {
        if (products != null) {
            products.remove(product);
        }
    }

    public void clearCart() {
       if (products != null) {
           products.clear();
       }
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
        int result = 31;
        for (Product product : products) {
            result = 31 * result + product.hashCode();
        }
        return result;
    }

}
