package com.hanocybous.ecommercesystem.entity.order;

import com.hanocybous.ecommercesystem.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private EOrder EOrder;
    private Integer quantity;
    private Double price;
    private Double total;

    public OrderItem(Product product, EOrder EOrder, Integer quantity, Double price, Double total) {
        this.product = product;
        this.EOrder = EOrder;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public OrderItem(Product product, int i, double price) {
        this.product = product;
        this.quantity = i;
        this.price = price;
        this.total = price * i;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + EOrder +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;

        if (!product.equals(orderItem.product)) return false;
        if (!EOrder.equals(orderItem.EOrder)) return false;
        if (!quantity.equals(orderItem.quantity)) return false;
        if (!price.equals(orderItem.price)) return false;
        return total.equals(orderItem.total);
    }

    @Override
    public int hashCode() {
        return total.hashCode();
    }

}
