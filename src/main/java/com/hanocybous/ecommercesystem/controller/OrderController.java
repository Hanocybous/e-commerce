package com.hanocybous.ecommercesystem.controller;

import com.hanocybous.ecommercesystem.dto.order.OrderDto;
import com.hanocybous.ecommercesystem.service.order.orderimpl.OrderService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAllOrders")
    @ResponseBody
    public void getAllOrders() {
        orderService.getAllOrders();
    }

    @GetMapping("/getOrderById/{orderId}")
    @ResponseBody
    public void getOrderById(
            @RequestBody
            @PathVariable Long orderId) {
        orderService.getOrderById(orderId);
    }

    @GetMapping("/getOrderByUserId/{userId}")
    @ResponseBody
    public void getOrderByUserId(
            @RequestBody
            @PathVariable Long userId) {
        orderService.getOrderByUserId(userId);
    }

    @GetMapping("/getOrderByUserIdAndProductId/{userId}/{productId}")
    @ResponseBody
    public void getOrderByUserIdAndProductId(
            @RequestBody
            @PathVariable Long userId,
            @RequestBody
            @PathVariable Long productId) {
        orderService.getOrderByUserIdAndProductId(userId, productId);
    }

    @GetMapping("/getOrderByProductId/{productId}")
    @ResponseBody
    public List<OrderDto> getOrderByProductId(
            @RequestBody
            @PathVariable Long productId) {
        return orderService.getOrderByProductId(productId);
    }

    @GetMapping("/getOrderByProductName/{productName}")
    @ResponseBody
    public List<OrderDto> getOrderByProductName(
            @RequestBody
            @PathVariable String productName) {
        return orderService.getOrderByProductName(productName);
    }

    @GetMapping("/getOrderByCategory/{category}")
    @ResponseBody
    public List<OrderDto> getOrderByCategory(
            @RequestBody
            @PathVariable String category) {
        return orderService.getOrderByCategory(category);
    }

    @GetMapping("/getOrderByTotalAmount/{totalAmount}")
    @ResponseBody
    public List<OrderDto> getOrderByTotalAmount(
            @RequestBody
            @PathVariable Double totalAmount) {
        return orderService.getOrderByTotalAmount(totalAmount);
    }

    @GetMapping("/getOrderByTotalShipping/{totalShipping}")
    @ResponseBody
    public List<OrderDto> getOrderByTotalShipping(
            @RequestBody
            @PathVariable Double totalShipping) {
        return orderService.getOrderByTotalShipping(totalShipping);
    }

    @GetMapping("/getOrderByTotalAmountAndTotalShipping/{totalAmount}/{totalShipping}")
    @ResponseBody
    public List<OrderDto> getOrderByTotalAmountAndTotalShipping(
            @RequestBody
            @PathVariable Double totalAmount,
            @RequestBody
            @PathVariable Double totalShipping) {
        return orderService.getOrderByTotalAmountAndTotalShipping(totalAmount, totalShipping);
    }

    @PostMapping("/addOrder")
    @ResponseBody
    public void addOrder(
            @RequestBody
            @ModelAttribute OrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    @PutMapping("/updateOrder")
    @ResponseBody
    public void updateOrder(
            @RequestBody
            @ModelAttribute @NotNull OrderDto orderDto) {
        orderService.updateOrder(orderDto.toOrder());
    }

    @DeleteMapping("/deleteOrderById/{orderId}")
    @ResponseBody
    public void deleteOrderById(
            @RequestBody
            @PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
    }

    @DeleteMapping("/deleteOrderByUserId/{userId}")
    @ResponseBody
    public void deleteOrderByUserId(
            @RequestBody
            @PathVariable Long userId) {
        orderService.deleteOrderByUserId(userId);
    }

    @DeleteMapping("/deleteOrderByProductId/{productId}")
    @ResponseBody
    public void deleteOrderByProductId(
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteOrderByProductId(productId);
    }

    @DeleteMapping("/deleteOrderByUserIdAndProductId/{userId}/{productId}")
    @ResponseBody
    public void deleteOrderByUserIdAndProductId(
            @RequestBody
            @PathVariable Long userId,
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteOrderByUserIdAndProductId(userId, productId);
    }

    @DeleteMapping("/deleteProductFromOrder/{orderId}/{productName}/{category}")
    @ResponseBody
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
    @ResponseBody
    public void deleteProductFromOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteProductFromOrder(orderId, productId);
    }

    @DeleteMapping("/deleteProductFromOrder/{orderId}/{productName}")
    @ResponseBody
    public void deleteProductFromOrder(
            @RequestBody
            @PathVariable Long orderId,
            @RequestBody
            @PathVariable String productName) {
        orderService.deleteProductFromOrder(orderId, productName);
    }

    @DeleteMapping("/deleteProductFromOrder/{orderId}")
    @ResponseBody
    public void deleteProductFromOrder(
            @RequestBody
            @PathVariable Long orderId) {
        orderService.deleteProductFromOrder(orderId);
    }

    @DeleteMapping("/deleteAllOrders")
    @ResponseBody
    public void deleteAllOrders() {
        orderService.deleteAllOrders();
    }

    @DeleteMapping("/deleteAllOrdersByUserId/{userId}")
    @ResponseBody
    public void deleteAllOrdersByUserId(
            @RequestBody
            @PathVariable Long userId) {
        orderService.deleteAllOrdersByUserId(userId);
    }

    @DeleteMapping("/deleteAllOrdersByProductId/{productId}")
    @ResponseBody
    public void deleteAllOrdersByProductId(
            @RequestBody
            @PathVariable Long productId) {
        orderService.deleteAllOrdersByProductId(productId);
    }

}
