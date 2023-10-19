package com.hanocybous.ecommercesystem.entity.order;

import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod;
import com.hanocybous.ecommercesystem.entity.product.Product;
import com.hanocybous.ecommercesystem.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private User userId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String shippingAddress;

    private String paymentMethod;

    private Double totalAmount;

    public Order(User userId,
                 List<OrderItem> orderItems,
                 LocalDateTime orderDate,
                 OrderStatus status,
                 String shippingAddress,
                 String paymentMethod,
                 Double totalAmount) {
        this.userId = userId;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
    }

    public Order(Long id,
                 List<OrderItem> orderItems,
                 LocalDateTime orderDate,
                 OrderStatus status,
                 String shippingAddress,
                 @NotNull PaymentMethod paymentMethod,
                 Double totalAmount) {
        this.id = id;
        this.orderItems = orderItems;
        this.orderDate = orderDate;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod.toString();
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderItems=" + orderItems +
                ", orderDate=" + orderDate +
                ", status=" + status +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUserId().hashCode();
        result = 31 * result + getOrderItems().hashCode();
        result = 31 * result + getOrderDate().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getShippingAddress().hashCode();
        result = 31 * result + getPaymentMethod().hashCode();
        result = 31 * result + getTotalAmount().hashCode();
        return result;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    public void updateOrderItem(OrderItem orderItem) {
        orderItems.set(orderItems.indexOf(orderItem), orderItem);
    }

    public void updateOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void updateTotalAmount() {
        this.totalAmount = orderItems.stream()
                .mapToDouble(OrderItem::getTotal)
                .sum();
    }

    public void updateOrderDate() {
        this.orderDate = LocalDateTime.now();
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    // update an orderitem based on the product id
    public void updateOrderItemQuantity(Long productId, Integer quantity) {
        orderItems.stream()
                .filter(orderItem -> orderItem.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(orderItem -> {
                    orderItem.setQuantity(quantity);
                    orderItem.setTotal(orderItem.getProduct().getPrice() * quantity);
                });
    }

    // remove an orderitem based on the product id
    public void removeOrderItem(Long productId) {
        orderItems.stream()
                .filter(orderItem -> orderItem.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(orderItem -> orderItems.remove(orderItem));
    }

    public void addOrderItem(Product product) {
        orderItems.add(new OrderItem(product, 1, product.getPrice()));
    }
}
