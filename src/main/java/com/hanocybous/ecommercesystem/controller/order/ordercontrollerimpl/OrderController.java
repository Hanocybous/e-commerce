package com.hanocybous.ecommercesystem.controller.order.ordercontrollerimpl;

import com.hanocybous.ecommercesystem.controller.order.IOrderController;
import com.hanocybous.ecommercesystem.dto.order.OrderDto;
import com.hanocybous.ecommercesystem.entity.order.EOrder;
import com.hanocybous.ecommercesystem.service.order.orderimpl.OrderService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/order")
public class OrderController implements IOrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAllOrders")
    public void getAllOrders() {
        orderService.getAllOrders();
    }

    @GetMapping("/getOrderById/{orderId}")
    public void getOrderById(
            @RequestBody
            @PathVariable Long orderId) {
        orderService.getOrderById(orderId);
    }

    @GetMapping("/getOrderByUserId/{userId}")
    public void getOrderByUserId(
            @RequestBody
            @PathVariable Long userId) {
        orderService.getOrderByUserId(userId);
    }

    @GetMapping("/getOrderByUserIdAndProductId/{userId}/{productId}")
    public void getOrderByUserIdAndProductId(
            @RequestBody
            @PathVariable Long userId,
            @RequestBody
            @PathVariable Long productId) {
        orderService.getOrderByUserIdAndProductId(userId, productId);
    }

    @GetMapping("/getOrderByProductId/{productId}")
    public List<OrderDto> getOrderByProductId(
            @RequestBody
            @PathVariable Long productId) {
        return orderService.getOrderByProductId(productId);
    }

    @GetMapping("/getOrderByProductName/{productName}")
    public List<OrderDto> getOrderByProductName(
            @RequestBody
            @PathVariable String productName) {
        return orderService.getOrderByProductName(productName);
    }

    @GetMapping("/getOrderByCategory/{category}")
    public List<OrderDto> getOrderByCategory(
            @RequestBody
            @PathVariable String category) {
        return orderService.getOrderByCategory(category);
    }

    @GetMapping("/getOrderByTotalAmount/{totalAmount}")
    public List<OrderDto> getOrderByTotalAmount(
            @RequestBody
            @PathVariable Double totalAmount) {
        return orderService.getOrderByTotalAmount(totalAmount);
    }

    @GetMapping("/getOrderByTotalShipping/{totalShipping}")
    public List<OrderDto> getOrderByTotalShipping(
            @RequestBody
            @PathVariable Double totalShipping) {
        return orderService.getOrderByTotalShipping(totalShipping);
    }

    @GetMapping("/getOrderByTotalAmountAndTotalShipping/{totalAmount}/{totalShipping}")
    public List<OrderDto> getOrderByTotalAmountAndTotalShipping(
            @RequestBody
            @PathVariable Double totalAmount,
            @RequestBody
            @PathVariable Double totalShipping) {
        return orderService.getOrderByTotalAmountAndTotalShipping(totalAmount, totalShipping);
    }

    @PostMapping("/addOrder")
    public void addOrder(
            @RequestBody
            @ModelAttribute OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    @PutMapping("/updateOrder")
    public void updateOrder(
            @RequestBody
            @ModelAttribute @NotNull OrderDto orderDto) {
        orderService.updateOrder(orderDto.toOrder());
    }

    @DeleteMapping("/deleteOrderById/{orderId}")
    public void deleteOrderById(
            @RequestBody
            @PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }

    @DeleteMapping("/deleteOrderByUserId/{userId}")
    public void deleteOrderByUserId(
            @RequestBody
            @PathVariable Long userId) {
        orderService.deleteOrderByUserId(userId);
    }

    @DeleteMapping("/deleteOrderByProductId/{productId}")
    public void deleteOrderByProductId(
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteOrderByProductId(productId);
    }

    @DeleteMapping("/deleteOrderByUserIdAndProductId/{userId}/{productId}")
    public void deleteOrderByUserIdAndProductId(
            @RequestBody
            @PathVariable Long userId,
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteOrderByUserIdAndProductId(userId, productId);
    }

    @DeleteMapping("/deleteProductFromOrder/{orderId}/{productName}/{category}")
    public void deleteProductFromOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @PathVariable String productName,
            @RequestBody
            @PathVariable String category) {
        orderService.deleteProductFromOrder(orderId, productName, category);
    }

    @DeleteMapping("/deleteProductFromOrder/{orderId}/{productId}")
    public void deleteProductFromOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteProductFromOrder(orderId, productId);
    }

    @DeleteMapping("/deleteProductFromOrder/{orderId}/{productName}")
    public void deleteProductFromOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @PathVariable String productName) {
        orderService.deleteProductFromOrder(orderId, productName);
    }

    @DeleteMapping("/deleteProductFromOrder/{orderId}")
    public void deleteProductFromOrder(
            @RequestBody
            @PathVariable Long orderId) {
        orderService.deleteProductFromOrder(orderId);
    }

    @DeleteMapping("/deleteAllOrders")
    public void deleteAllOrders() {
        orderService.deleteAllOrders();
    }

    @DeleteMapping("/deleteAllOrdersByUserId/{userId}")
    public void deleteAllOrdersByUserId(
            @RequestBody
            @PathVariable Long userId) {
        orderService.deleteAllOrdersByUserId(userId);
    }

    @DeleteMapping("/deleteAllOrdersByProductId/{productId}")
    public void deleteAllOrdersByProductId(
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteAllOrdersByProductId(productId);
    }

    @PostMapping("/updateOrder/{orderId}/{productId}")
    public void updateOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @PathVariable Long productId) {
        orderService.updateOrder(orderId, productId);
    }

    @PostMapping("/updateOrder/{orderId}/{productName}")
    public void updateOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @PathVariable String productName) {
        orderService.updateOrder(orderId, Long.valueOf(productName));
    }

    @PostMapping("/updateOrder/{orderId}/{productName}/{category}")
    public void updateOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @PathVariable String productName,
            @RequestBody
            @PathVariable String category) {
        orderService.updateOrder(orderId, productName, category);
    }

    @PostMapping("/updateOrder/{orderId}/")
    public void updateOrder(
            @RequestBody
            @PathVariable Long orderId) {
        orderService.updateOrder(orderId);
    }

    @PostMapping("/updateOrder/{orderId}")
    public void updateOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @ModelAttribute EOrder EOrder) {
        orderService.updateOrder(orderId, EOrder);
    }

    @DeleteMapping("/deleteAllProductsFromAllOrdersByCategory/{category}")
    public void deleteAllProductsFromAllOrdersByCategory(
            @RequestBody
            @PathVariable String category) {
        orderService.deleteAllProductsFromAllOrdersByCategory(category);
    }

    @DeleteMapping("/deleteAllProductsFromAllOrdersByProductName/{productName}")
    public void deleteAllProductsFromAllOrders(
            @RequestBody
            @PathVariable String productName) {
        orderService.deleteAllProductsFromAllOrders(productName);
    }

    @DeleteMapping("/deleteAllProductsFromAllOrdersByProductId/{productId}")
    public void deleteAllProductsFromAllOrders(
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteAllProductsFromAllOrders(productId);
    }

    @DeleteMapping("/deleteAllProductsFromAllOrders")
    public void deleteAllProductsFromAllOrders() {
        orderService.deleteAllProductsFromAllOrders();
    }

    @DeleteMapping("/deleteAllProductsFromOrder/{orderId}")
    public void deleteAllProductsFromOrder(
            @RequestBody
            @PathVariable Long orderId) {
        orderService.deleteAllProductsFromOrder(orderId);
    }

    @DeleteMapping("/deleteAllProductsFromOrder{productId}")
    public void removeProductFromOrder(
            @RequestBody
            @PathVariable Long productId) {
        orderService.removeProductFromOrder(productId);
    }

    @PostMapping("/addProductToOrder/{productId}")
    public void addProductToOrder(
            @RequestBody
            @PathVariable Long productId) {
        orderService.addProductToOrder(productId);
    }

}
