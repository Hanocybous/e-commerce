package com.hanocybous.ecommercesystem.service.order.orderimpl;

import com.hanocybous.ecommercesystem.dto.order.OrderDto;
import com.hanocybous.ecommercesystem.entity.order.EOrder;
import com.hanocybous.ecommercesystem.repository.order.OrderRepository;
import com.hanocybous.ecommercesystem.repository.product.ProductRepository;
import com.hanocybous.ecommercesystem.service.order.IOrderService;
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

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = null;
    }

    public void addProductToOrder(Long productId) {
        EOrder EOrder = orderRepository.findById(productId).orElse(new EOrder());
        assert productRepository != null;
        productRepository.findById(productId).ifPresent(product -> {
            if (product.getQuantity() > 0) {
                product.setQuantity(product.getQuantity() - 1);
                EOrder.addOrderItem(product);
                orderRepository.save(EOrder);
                productRepository.save(product);
            }
        });
    }

    public void removeProductFromOrder(Long productId) {
        assert productRepository != null;
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

    public void updateOrder(Long orderId, EOrder EOrder) {
        orderRepository
                .findById(orderId)
                .ifPresent(order1 -> {
            order1.setOrderItems(
                    EOrder.getOrderItems());
            orderRepository.save(order1);
        });
    }

    public void updateOrder(EOrder EOrder) {
        orderRepository.save(EOrder);
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

    public List<EOrder> getAllOrders() {
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

    public void getOrderById(Long orderId) {
        if (orderId == null || orderId < 0) {
            return;
        }
        orderRepository.findById(orderId);
    }

    public void getOrderByUserIdAndProductId(Long userId, Long productId) {
        if (userId == null || userId < 0 || productId == null || productId < 0) {
            return;
        }
        orderRepository.getOrderByUserIdAndProductId(userId, productId);
    }

    public void addOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return;
        }
        orderRepository.save(orderDto.toOrder());
    }

    public void deleteOrderById(Long orderId) {
        if (orderId == null || orderId < 0) {
            return;
        }
        orderRepository.deleteById(orderId);
    }

    public void deleteOrderByUserId(Long userId) {
        if (userId == null || userId < 0) {
            return;
        }
        orderRepository.deleteOrderByUserId(userId);
    }

    public void deleteOrderByProductId(Long productId) {
        if (productId == null || productId < 0) {
            return;
        }
        orderRepository.deleteOrderByProductId(productId);
    }

    public void deleteOrderByUserIdAndProductId(Long userId, Long productId) {
        if (userId == null || userId < 0 || productId == null || productId < 0) {
            return;
        }
        orderRepository.deleteOrderByUserIdAndProductId(userId, productId);
    }

    public void deleteProductFromOrder(Long orderId) {
        if (orderId == null || orderId < 0) {
            return;
        }
        orderRepository.findById(orderId).ifPresent(order -> {
            order.getOrderItems().clear();
            orderRepository.save(order);
        });
    }

    public void deleteAllOrdersByUserId(Long userId) {
        if (userId == null || userId < 0) {
            return;
        }
        orderRepository.deleteAllOrdersByUserId(userId);
    }

    public void deleteAllOrdersByProductId(Long productId) {
        if (productId == null || productId < 0) {
            return;
        }
        orderRepository.deleteAllOrdersByProductId(productId);
    }

    public void updateOrder(Long orderId, String productName, String category) {
        if (orderId == null ||
                orderId < 0 ||
                productName == null ||
                productName.isEmpty() ||
                category == null ||
                category.isEmpty()) {
            return;
        }
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
}
