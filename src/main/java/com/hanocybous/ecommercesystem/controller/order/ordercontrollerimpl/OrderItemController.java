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
    @ResponseBody
    public Double getTotalByOrderId(
            @RequestBody
            @PathVariable Long orderId) {
        return orderItemService.getTotalByOrderId(orderId);
    }

    @GetMapping("/getOrderItemByProductId/{productId}")
    @ResponseBody
    public List<OrderItem> getOrderItemByProductId(
            @RequestBody
            @PathVariable Long productId) {
        return orderItemService.getOrderItemByProductId(productId);
    }

    @GetMapping("/getOrderItemByOrderId/{orderId}")
    @ResponseBody
    public List<OrderItem> getOrderItemByOrderId(
            @RequestBody
            @PathVariable Long orderId) {
        return orderItemService.getOrderItemByOrderId(orderId);
    }

    @GetMapping("/getOrderItemById/{orderItemId}")
    @ResponseBody
    public OrderItem getOrderItemById(
            @RequestBody
            @PathVariable Long orderItemId) {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @PostMapping("/saveOrderItem")
    @ResponseBody
    public OrderItem saveOrderItem(
            @RequestBody
            @ModelAttribute OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }

    @DeleteMapping("/deleteOrderItemById/{orderItemId}")
    @ResponseBody
    public void deleteOrderItemById(
            @RequestBody
            @PathVariable Long orderItemId) {
        orderItemService.deleteOrderItemById(orderItemId);
    }

    @GetMapping("/getOrderItemByOrderIdAndProductId/{orderId}/{productId}")
    @ResponseBody
    public List<OrderItem> getOrderItemByOrderIdAndProductId(
            @RequestBody
            @PathVariable Long orderId,
            @PathVariable Long productId) {
        return orderItemService.getOrderItemByOrderIdAndProductId(orderId, productId);
    }

    @GetMapping("/getAllOrderItemsSortedByQuantity")
    @ResponseBody
    public List<OrderItem> getAllOrderItemsSortedByQuantity() {
        return orderItemService.getAllOrderItemsSortedByQuantity();
    }

    @GetMapping("/getAllOrderItemsSortedByPrice")
    @ResponseBody
    public List<OrderItem> getAllOrderItemsSortedByPrice() {
        return orderItemService.getAllOrderItemsSortedByPrice();
    }

    @GetMapping("/getAllOrderItemsSortedByTotal")
    @ResponseBody
    public List<OrderItem> getAllOrderItemsSortedByTotal() {
        return orderItemService.getAllOrderItemsSortedByTotal();
    }

    @PostMapping("/save")
    @ResponseBody
    public void save(
            @RequestBody
            @ModelAttribute OrderItem orderItem) {
        orderItemService.save(orderItem);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public void delete(
            @RequestBody
            @ModelAttribute OrderItem orderItem) {
        orderItemService.delete(orderItem);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public void deleteById(
            @RequestBody
            @PathVariable Long id) {
        orderItemService.deleteById(id);
    }

    @DeleteMapping("/deleteOrderItemByOrderIdAndProductId/{orderId}/{productId}")
    @ResponseBody
    public void deleteOrderItemByOrderIdAndProductId(
            @RequestBody
            @PathVariable Long orderId,
            @PathVariable Long productId) {
        orderItemService.deleteOrderItemByOrderIdAndProductId(orderId, productId);
    }

    @DeleteMapping("/deleteOrderItemByOrderId/{orderId}")
    @ResponseBody
    public void deleteOrderItemByOrderId(
            @RequestBody
            @PathVariable Long orderId) {
        orderItemService.deleteOrderItemByOrderId(orderId);
    }

    @DeleteMapping("/deleteOrderItemByProductId/{productId}")
    @ResponseBody
    public void deleteOrderItemByProductId(
            @RequestBody
            @PathVariable Long productId) {
        orderItemService.deleteOrderItemByProductId(productId);
    }

    @GetMapping("/getAllOrderItems")
    @ResponseBody
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/getAllOrderItemsByOrderIds/{orderIds}")
    @ResponseBody
    public List<OrderItem> getAllOrderItemsByOrderIds(
            @RequestBody
            @PathVariable List<Long> orderIds) {
        return orderItemService.getAllOrderItemsByOrderIds(orderIds);
    }

    @GetMapping("/getAllOrderItemsByProductIds/{productIds}")
    @ResponseBody
    public List<OrderItem> getAllOrderItemsByProductIds(
            @RequestBody
            @PathVariable List<Long> productIds) {
        return orderItemService.getAllOrderItemsByProductIds(productIds);
    }

    @DeleteMapping("/deleteAll")
    @ResponseBody
    public void deleteAll() {
        orderItemService.deleteAll();
    }

    @DeleteMapping("/deleteAll/{orderItems}")
    @ResponseBody
    public void deleteAll(
            @RequestBody
            @PathVariable List<OrderItem> orderItems) {
        orderItemService.deleteAll(orderItems);
    }

    @DeleteMapping("/deleteAllById/{ids}")
    @ResponseBody
    public void deleteAllById(
            @RequestBody
            @PathVariable List<Long> ids) {
        orderItemService.deleteAllById(ids);
    }

}
