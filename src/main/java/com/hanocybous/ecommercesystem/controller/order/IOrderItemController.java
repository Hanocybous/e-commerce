package com.hanocybous.ecommercesystem.controller.order;

import com.hanocybous.ecommercesystem.entity.order.OrderItem;

import java.util.List;

public interface IOrderItemController {

    Double getTotalByOrderId(Long orderId);

    List<OrderItem> getOrderItemByProductId(Long productId);

    List<OrderItem> getOrderItemByOrderId(Long orderId);

    OrderItem getOrderItemById(Long orderItemId);

    OrderItem saveOrderItem(OrderItem orderItem);

    void deleteOrderItemById(Long orderItemId);

    List<OrderItem> getOrderItemByOrderIdAndProductId(Long orderId, Long productId);

    void deleteById(Long orderItemId);

    void deleteAll();

    void deleteAllById(List<Long> orderItemIds);

}
