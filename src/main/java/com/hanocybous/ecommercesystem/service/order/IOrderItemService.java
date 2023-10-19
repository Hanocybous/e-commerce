package com.hanocybous.ecommercesystem.service.order;

import com.hanocybous.ecommercesystem.entity.order.OrderItem;

import java.util.List;

public interface IOrderItemService {

    Double getTotalByOrderId(Long orderId);

    List<OrderItem> getOrderItemByProductId(Long productId);

    List<OrderItem> getOrderItemByOrderId(Long orderId);

    OrderItem getOrderItemById(Long orderItemId);

    OrderItem saveOrderItem(OrderItem orderItem);

    void deleteOrderItemById(Long orderItemId);

    void deleteOrderItemByOrderId(Long orderId);

    void deleteOrderItemByProductId(Long productId);

    List<OrderItem> getAllOrderItems();

    List<OrderItem> getAllOrderItemsByOrderIds(List<Long> orderIds);

    List<OrderItem> getAllOrderItemsByProductIds(List<Long> productIds);

}
