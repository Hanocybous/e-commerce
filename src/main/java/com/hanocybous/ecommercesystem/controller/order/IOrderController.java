package com.hanocybous.ecommercesystem.controller.order;

import com.hanocybous.ecommercesystem.dto.order.OrderDto;

import java.util.List;

public interface IOrderController {

    void getAllOrders();

    void getOrderById(Long orderId);

    void getOrderByUserId(Long userId);

    List<OrderDto> getOrderByProductId(Long productId);

    void addOrder(OrderDto orderDto);

    void updateOrder(OrderDto orderDto);

    void deleteAllOrders();

    void deleteOrderByUserId(Long userId);

    void deleteOrderByProductId(Long productId);

}
