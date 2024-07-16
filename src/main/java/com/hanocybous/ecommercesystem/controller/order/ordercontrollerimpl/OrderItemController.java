package com.hanocybous.ecommercesystem.controller.order.ordercontrollerimpl;

import com.hanocybous.ecommercesystem.controller.order.IOrderItemController;
import com.hanocybous.ecommercesystem.entity.order.OrderItem;
import com.hanocybous.ecommercesystem.service.order.orderitemimpl.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/orderItem")
public class OrderItemController implements IOrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/getTotalByOrderId/{orderId}")
    public Double getTotalByOrderId(
            @RequestBody
            @PathVariable Long orderId) {
        return orderItemService.getTotalByOrderId(orderId);
    }

    @GetMapping("/getOrderItemByProductId/{productId}")
    public List<OrderItem> getOrderItemByProductId(
            @RequestBody
            @PathVariable Long productId) {
        return orderItemService.getOrderItemByProductId(productId);
    }

    @GetMapping("/getOrderItemByOrderId/{orderId}")
    public List<OrderItem> getOrderItemByOrderId(
            @RequestBody
            @PathVariable Long orderId) {
        return orderItemService.getOrderItemByOrderId(orderId);
    }

    @GetMapping("/getOrderItemById/{orderItemId}")
    public OrderItem getOrderItemById(
            @RequestBody
            @PathVariable Long orderItemId) {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @PostMapping("/saveOrderItem")
    public OrderItem saveOrderItem(
            @RequestBody
            @ModelAttribute OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }

    @DeleteMapping("/deleteOrderItemById/{orderItemId}")
    public void deleteOrderItemById(
            @RequestBody
            @PathVariable Long orderItemId) {
        orderItemService.deleteOrderItemById(orderItemId);
    }

    @GetMapping("/getOrderItemByOrderIdAndProductId/{orderId}/{productId}")
    public List<OrderItem> getOrderItemByOrderIdAndProductId(
            @RequestBody
            @PathVariable Long orderId,
            @PathVariable Long productId) {
        return orderItemService.getOrderItemByOrderIdAndProductId(orderId, productId);
    }

    @GetMapping("/getAllOrderItemsSortedByQuantity")
    public List<OrderItem> getAllOrderItemsSortedByQuantity() {
        return orderItemService.getAllOrderItemsSortedByQuantity();
    }

    @GetMapping("/getAllOrderItemsSortedByPrice")
    public List<OrderItem> getAllOrderItemsSortedByPrice() {
        return orderItemService.getAllOrderItemsSortedByPrice();
    }

    @GetMapping("/getAllOrderItemsSortedByTotal")
    public List<OrderItem> getAllOrderItemsSortedByTotal() {
        return orderItemService.getAllOrderItemsSortedByTotal();
    }

    @PostMapping("/save")
    public void save(
            @RequestBody
            @ModelAttribute OrderItem orderItem) {
        orderItemService.save(orderItem);
    }

    @DeleteMapping("/delete")
    public void delete(
            @RequestBody
            @ModelAttribute OrderItem orderItem) {
        orderItemService.delete(orderItem);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(
            @RequestBody
            @PathVariable Long id) {
        orderItemService.deleteById(id);
    }

    @DeleteMapping("/deleteOrderItemByOrderIdAndProductId/{orderId}/{productId}")
    public void deleteOrderItemByOrderIdAndProductId(
            @RequestBody
            @PathVariable Long orderId,
            @PathVariable Long productId) {
        orderItemService.deleteOrderItemByOrderIdAndProductId(orderId, productId);
    }

    @DeleteMapping("/deleteOrderItemByOrderId/{orderId}")
    public void deleteOrderItemByOrderId(
            @RequestBody
            @PathVariable Long orderId) {
        orderItemService.deleteOrderItemByOrderId(orderId);
    }

    @DeleteMapping("/deleteOrderItemByProductId/{productId}")
    public void deleteOrderItemByProductId(
            @RequestBody
            @PathVariable Long productId) {
        orderItemService.deleteOrderItemByProductId(productId);
    }

    @GetMapping("/getAllOrderItems")
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/getAllOrderItemsByOrderIds/{orderIds}")
    public List<OrderItem> getAllOrderItemsByOrderIds(
            @RequestBody
            @PathVariable List<Long> orderIds) {
        return orderItemService.getAllOrderItemsByOrderIds(orderIds);
    }

    @GetMapping("/getAllOrderItemsByProductIds/{productIds}")
    public List<OrderItem> getAllOrderItemsByProductIds(
            @RequestBody
            @PathVariable List<Long> productIds) {
        return orderItemService.getAllOrderItemsByProductIds(productIds);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        orderItemService.deleteAll();
    }

    @DeleteMapping("/deleteAll/{orderItems}")
    public void deleteAll(
            @RequestBody
            @PathVariable List<OrderItem> orderItems) {
        orderItemService.deleteAll(orderItems);
    }

    @DeleteMapping("/deleteAllById/{ids}")
    public void deleteAllById(
            @RequestBody
            @PathVariable List<Long> ids) {
        orderItemService.deleteAllById(ids);
    }

}
