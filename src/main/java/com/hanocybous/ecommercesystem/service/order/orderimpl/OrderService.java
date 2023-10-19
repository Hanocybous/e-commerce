package com.hanocybous.ecommercesystem.service.order;

import com.hanocybous.ecommercesystem.dto.order.OrderDto;
import com.hanocybous.ecommercesystem.entity.order.Order;
import com.hanocybous.ecommercesystem.repository.order.OrderRepository;
import com.hanocybous.ecommercesystem.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class OrderService implements IOrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(ProductRepository productRepository,
                        OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public void addProductToOrder(Long productId) {
        Order order = orderRepository.findById(productId).orElse(new Order());
        productRepository.findById(productId).ifPresent(product -> {
            if (product.getQuantity() > 0) {
                product.setQuantity(product.getQuantity() - 1);
                order.addOrderItem(product);
                orderRepository.save(order);
                productRepository.save(product);
            }
        });
    }

    public void removeProductFromOrder(Long productId) {
        productRepository.findById(productId).ifPresent(product -> {
            for (int i = 0; i < product.getQuantity(); i++) {
                product.setQuantity(product.getQuantity() + 1);
            }
            productRepository.save(product);
        });
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    public void deleteAllProductsFromOrder(Long orderId) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.getOrderItems().clear();
            orderRepository.save(order);
        });
    }

    public void deleteAllProductsFromAllOrders() {
        orderRepository.findAll().forEach(order -> {
            order.getOrderItems().clear();
            orderRepository.save(order);
        });
    }

    public void deleteAllProductsFromAllOrders(Long productId) {
        orderRepository
                .findAll()
                .forEach(order -> {
            order.getOrderItems()
                    .removeIf(orderItem ->
                    orderItem.getProduct()
                            .getId()
                            .equals(productId));
            orderRepository.save(order);
        });
    }

    public void deleteAllProductsFromAllOrders(String productName) {
        orderRepository.findAll().forEach(order -> {
            order.getOrderItems().removeIf(orderItem ->
                    orderItem.getProduct()
                            .getName()
                            .equals(productName));
            orderRepository.save(order);
        });
    }

    public void deleteAllProductsFromAllOrdersByCategory(String category) {
        orderRepository.findAll().forEach(order -> {
            order.getOrderItems().removeIf(orderItem ->
                    orderItem.getProduct()
                            .getCategory()
                            .equals(category));
            orderRepository.save(order);
        });
    }

    public void updateOrder(Long orderId, Order order) {
        orderRepository
                .findById(orderId)
                .ifPresent(order1 -> {
            order1.setOrderItems(
                    order.getOrderItems());
            orderRepository.save(order1);
        });
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Long orderId) {
        orderRepository
                .findById(orderId)
                .ifPresent(orderRepository::save);
    }

    public void updateOrder(Long orderId, Long productId) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.getOrderItems().removeIf(orderItem ->
                    orderItem.getProduct()
                            .getId()
                            .equals(productId));
            orderRepository.save(order);
        });
    }

    public void deleteProductFromOrder(Long orderId, Long productId) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.getOrderItems().removeIf(orderItem ->
                    orderItem.getProduct()
                            .getId()
                            .equals(productId));
            orderRepository.save(order);
        });
    }

    public void deleteProductFromOrder(Long orderId, String productName) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.getOrderItems().removeIf(orderItem ->
                    orderItem.getProduct()
                            .getName()
                            .equals(productName));
            orderRepository.save(order);
        });
    }

    public void deleteProductFromOrder(Long orderId, String productName, String category) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.getOrderItems().removeIf(orderItem ->
                    orderItem.getProduct()
                            .getName()
                            .equals(productName)
                            && orderItem.getProduct()
                            .getCategory()
                            .equals(category));
            orderRepository.save(order);
        });
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderDto> getOrderByUserId(Long userId) {
        if (userId == null || userId < 0) {
            return Collections.emptyList();
        }
        return orderRepository.getOrderByUserId(userId);
    }

    public List<OrderDto> getOrderByProductId(Long productId) {
        if (productId == null || productId < 0) {
            return Collections.emptyList();
        }
        return orderRepository.getOrderByProductId(productId);
    }

    public List<OrderDto> getOrderByProductName(String productName) {
        if (productName == null || productName.isEmpty()) {
            return Collections.emptyList();
        }
        return orderRepository.getOrderByProductName(productName);
    }

    public List<OrderDto> getOrderByCategory(String category) {
        if (category == null || category.isEmpty()) {
            return Collections.emptyList();
        }
        return orderRepository.getOrderByCategory(category);
    }

    public List<OrderDto> getOrderByTotalAmount(Double totalAmount) {
        if (totalAmount == null || totalAmount < 0) {
            return Collections.emptyList();
        }
        return orderRepository.getOrderByTotalAmount(totalAmount);
    }

    public List<OrderDto> getOrderByTotalShipping(Double totalShipping) {
        if (totalShipping == null || totalShipping < 0) {
            return Collections.emptyList();
        }
        return orderRepository.getOrderByTotalShipping(totalShipping);
    }

    public List<OrderDto> getOrderByTotalAmountAndTotalShipping(Double totalAmount, Double totalShipping) {
        if (totalAmount == null || totalAmount < 0 || totalShipping == null || totalShipping < 0) {
            return Collections.emptyList();
        }
        return orderRepository.getOrderByTotalAmountAndTotalShipping(totalAmount, totalShipping);
    }

}
