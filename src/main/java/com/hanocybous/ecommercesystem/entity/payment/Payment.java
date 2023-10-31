package com.hanocybous.ecommercesystem.entity.payment;

import com.hanocybous.ecommercesystem.entity.order.EOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "FK_order_id"))
    private EOrder EOrder;

    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Double amount;

    public Payment(EOrder EOrder,
                   PaymentMethod paymentMethod,
                   Double amount) {
        this.EOrder = EOrder;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    // get order id from order
    public Long getOrderId() {
        return EOrder.getId();
    }

    // set order id from order
    public void setOrderId(Long orderId) {
        this.EOrder.setId(orderId);
    }

}
