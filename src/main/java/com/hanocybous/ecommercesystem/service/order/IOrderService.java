package com.hanocybous.ecommercesystem.service.order;

import com.hanocybous.ecommercesystem.dto.order.OrderDto;
import com.hanocybous.ecommercesystem.entity.order.Order;

import java.util.List;

public interface IOrderService {

    void addProductToOrder(Long productId);

    void removeProductFromOrder(Long productId);

    void deleteOrder(Long orderId);

    void deleteAllOrders();

    void deleteAllProductsFromOrder(Long orderId);

    void deleteAllProductsFromAllOrders();

    void deleteAllProductsFromAllOrders(Long productId);

    void updateOrder(Long orderId, Order order);

    void updateOrder(Long orderId, Long productId);

    List<OrderDto> getOrderByProductId(Long productId);

    List<OrderDto> getOrderByUserId(Long userId);

    List<OrderDto> getOrderByCategory(String category);

    List<Order> getAllOrders();

}
