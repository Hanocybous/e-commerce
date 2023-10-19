package com.hanocybous.ecommercesystem.service.order.orderitemimpl;

import com.hanocybous.ecommercesystem.entity.order.OrderItem;
import com.hanocybous.ecommercesystem.repository.order.OrderItemRepository;
import com.hanocybous.ecommercesystem.service.order.IOrderItemService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@Getter
@SuppressWarnings("unused")
public class OrderItemService implements IOrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    // get total by order id
    public Double getTotalByOrderId(Long orderId) {
        OrderItem orderItem = orderItemRepository.findById(orderId).orElse(new OrderItem());
        return orderItem.getTotal();
    }

    // get orderitem by product id
    public List<OrderItem> getOrderItemByProductId(Long productId) {
        OrderItem orderItem = orderItemRepository.findById(productId).orElse(new OrderItem());
        return orderItemRepository.getOrderItemByProductId(productId);
    }

    // get orderitem by order id
    public List<OrderItem> getOrderItemByOrderId(Long orderId) {
        OrderItem orderItem = orderItemRepository.findById(orderId).orElse(new OrderItem());
        return orderItemRepository.getOrderItemByOrderId(orderId);
    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        for (int i = 0; i < orderItemRepository.findAll().size(); i++) {
            OrderItem orderItem = orderItemRepository.findAll().get(i);
            if(orderItem.getId().equals(orderItemId)) {
                return orderItem;
            }
        }
        return null;
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void deleteOrderItemById(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }

    // get orderitem by order id and product id
    public List<OrderItem> getOrderItemByOrderIdAndProductId(Long orderId, Long productId) {
        OrderItem orderItem = orderItemRepository.findById(orderId).orElse(new OrderItem());
        return orderItemRepository.getOrderItemByOrderIdAndProductId(orderId, productId);
    }

    // get all orderitems sorted by quantity
    public List<OrderItem> getAllOrderItemsSortedByQuantity() {
        for (int i = 0; i < orderItemRepository.findAll().size(); i++) {
            OrderItem orderItem = orderItemRepository.findAll().get(i);
            orderItemRepository.findAll().sort(Comparator.comparing(OrderItem::getQuantity));
        }
        return orderItemRepository.findAll();
    }

    // get all orderitems sorted by price
    public List<OrderItem> getAllOrderItemsSortedByPrice() {
        for (int i = 0; i < orderItemRepository.findAll().size(); i++) {
            OrderItem orderItem = orderItemRepository.findAll().get(i);
            orderItemRepository.findAll().sort(Comparator.comparing(OrderItem::getPrice));
        }
        return orderItemRepository.findAll();
    }

    // get all orderitems sorted by total
    public List<OrderItem> getAllOrderItemsSortedByTotal() {
        for (int i = 0; i < orderItemRepository.findAll().size(); i++) {
            OrderItem orderItem = orderItemRepository.findAll().get(i);
            orderItemRepository.findAll().sort(Comparator.comparing(OrderItem::getTotal));
        }
        return orderItemRepository.findAll();
    }

    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void delete(OrderItem orderItem) {
        orderItemRepository.delete(orderItem);
    }

    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }

    public void deleteOrderItemByOrderIdAndProductId(Long orderId, Long productId) {
        for(int i = 0; i < orderItemRepository.findAll().size(); i++) {
            OrderItem orderItem = orderItemRepository.findAll().get(i);
            if(orderItem
                    .getOrder()
                    .getId()
                    .equals(orderId)
                    && orderItem
                    .getProduct()
                    .getId()
                    .equals(productId)) {
                orderItemRepository.delete(orderItem);
            }
        }

    }

    public void deleteOrderItemByOrderId(Long orderId) {
        for(int i = 0; i < orderItemRepository.findAll().size(); i++) {
            OrderItem orderItem = orderItemRepository.findAll().get(i);
            if(orderItem
                    .getOrder()
                    .getId()
                    .equals(orderId)) {
                orderItemRepository.delete(orderItem);
            }
        }
    }

    public void deleteOrderItemByProductId(Long productId) {
        for(int i = 0; i < orderItemRepository.findAll().size(); i++) {
            OrderItem orderItem = orderItemRepository.findAll().get(i);
            if(orderItem
                    .getProduct()
                    .getId()
                    .equals(productId)) {
                orderItemRepository.delete(orderItem);
            }
        }
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return null;
    }

    @Override
    public List<OrderItem> getAllOrderItemsByOrderIds(List<Long> orderIds) {
        return null;
    }

    @Override
    public List<OrderItem> getAllOrderItemsByProductIds(List<Long> productIds) {
        return null;
    }

    public void deleteAll() {
        orderItemRepository.deleteAll();
    }

    public void deleteAll(List<OrderItem> orderItems) {
        orderItemRepository.deleteAll(orderItems);
    }

    public void deleteAllById(List<Long> ids) {
        orderItemRepository.deleteAllById(ids);
    }

}
