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
    private Order order;
    private Integer quantity;
    private Double price;
    private Double total;

    public OrderItem(Product product, Order order, Integer quantity, Double price, Double total) {
        this.product = product;
        this.order = order;
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
                ", order=" + order +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;

        if (!id.equals(orderItem.id)) return false;
        if (!product.equals(orderItem.product)) return false;
        if (!order.equals(orderItem.order)) return false;
        if (!quantity.equals(orderItem.quantity)) return false;
        if (!price.equals(orderItem.price)) return false;
        return total.equals(orderItem.total);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + order.hashCode();
        result = 31 * result + quantity.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + total.hashCode();
        return result;
    }

}
