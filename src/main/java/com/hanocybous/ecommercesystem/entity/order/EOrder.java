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
public class EOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private User userId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String shippingAddress;

    private String paymentMethod;

    private Double totalAmount;

    public EOrder(User userId,
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

    public EOrder(Long id,
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
        if (o == null || getClass() != o.getClass()) return false;
        EOrder order = (EOrder) o;
        return orderItems.equals(order.orderItems);
    }

    @Override
    public int hashCode() {
        for (OrderItem orderItem : orderItems) {
            return orderItem.hashCode();
        }
        return 0;
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

    // update the total of an orderitem based on the product id
    public void updateOrderItemTotal(Long productId, Double total) {
        orderItems.stream()
                .filter(orderItem -> orderItem.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(orderItem -> orderItem.setTotal(total));
    }

    // calculate the total of an order
    public Double calculateTotal() {
        return orderItems.stream()
                .mapToDouble(OrderItem::getTotal)
                .sum();
    }

    public void addOrderItem(Product product) {
        orderItems.add(new OrderItem(product, 1, product.getPrice()));
    }

    public void updateOrderItem(OrderItem orderItem, OrderItem updatedOrderItem) {
        orderItems.set(orderItems.indexOf(orderItem), updatedOrderItem);
    }

    public void updateOrderItemQuantity(@NotNull OrderItem orderItem, int quantity) {
        orderItem.setQuantity(quantity);
    }

    public void updateOrderItemTotal(@NotNull OrderItem orderItem, double total) {
        orderItem.setTotal(total);
    }

}
