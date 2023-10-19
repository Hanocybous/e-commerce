package com.hanocybous.ecommercesystem.repository.order;

import com.hanocybous.ecommercesystem.entity.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query(value = 
            "SELECT SUM(total) F" +
            "FROM order_item " +
            "WHERE order_id = ?1", nativeQuery = true)
    Double getTotalByOrderId(Long orderId);

    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "WHERE product_id = ?1", nativeQuery = true)
    List<OrderItem> getOrderItemByProductId(Long productId);

    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "WHERE order_id = ?1", nativeQuery = true)
    List<OrderItem> getOrderItemByOrderId(Long orderId);

    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "WHERE order_id = ?1 " +
            "AND product_id = ?2", nativeQuery = true)
    List<OrderItem> getOrderItemByOrderIdAndProductId(Long orderId, Long productId);

    // get all orderitems sorted by quantity
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "ORDER BY quantity", nativeQuery = true)
    List<OrderItem> getAllOrderItemsSortedByQuantity();

    // get all orderitems sorted by price
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "ORDER BY price", nativeQuery = true)
    List<OrderItem> getAllOrderItemsSortedByPrice();

    // get all orderitems sorted by total
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "ORDER BY total", nativeQuery = true)
    List<OrderItem> getAllOrderItemsSortedByTotal();

    // get all orderitems sorted by product id
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "ORDER BY product_id", nativeQuery = true)
    List<OrderItem> getAllOrderItemsSortedByProductId();

    // get all orderitems sorted by order id
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "ORDER BY order_id", nativeQuery = true)
    List<OrderItem> getAllOrderItemsSortedByOrderId();

    // delete orderitem by order id
    @Modifying
    @Query(value = 
            "DELETE " +
            "FROM order_item " +
            "WHERE order_id = ?1", nativeQuery = true)
    void deleteOrderItemByOrderId(Long orderId);

    // delete orderitem by product id
    @Modifying
    @Query(value = 
            "DELETE " +
            "FROM order_item " +
            "WHERE product_id = ?1", nativeQuery = true)
    void deleteOrderItemByProductId(Long productId);

    // delete orderitem by order id and product id
    @Modifying
    @Query(value = 
            "DELETE " +
            "FROM order_item " +
            "WHERE order_id = ?1 " +
            "AND product_id = ?2", nativeQuery = true)
    void deleteOrderItemByOrderIdAndProductId(Long orderId, Long productId);

    // update orderitem by order id and product id
    @Modifying
    @Query(value = 
            "UPDATE order_item " +
            "SET quantity = ?3, price = ?4, total = ?5 " +
            "WHERE order_id = ?1 " +
            "AND product_id = ?2", nativeQuery = true)
    void updateOrderItemByOrderIdAndProductId(Long orderId,
                                              Long productId,
                                              Integer quantity,
                                              Double price,
                                              Double total);

    // update orderitem by order id
    @Modifying
    @Query(value = 
            "UPDATE order_item " +
            "SET order_id = ?2 " +
            "WHERE order_id = ?1", nativeQuery = true)
    void updateOrderItemByOrderId(Long orderId, Long newOrderId);

    // update orderitem by product id
    @Modifying
    @Query(value = 
            "UPDATE order_item " +
            "SET product_id = ?2 " +
            "WHERE product_id = ?1", nativeQuery = true)
    void updateOrderItemByProductId(Long productId, Long newProductId);

    // add orderitem by order id and product id
    @Modifying
    @Query(value = 
            "INSERT INTO order_item (order_id, product_id, quantity, price, total) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void addOrderItemByOrderIdAndProductId(Long orderId,
                                           Long productId,
                                           Integer quantity,
                                           Double price,
                                           Double total);

    // add orderitem by order id
    @Modifying
    @Query(value = 
            "INSERT INTO order_item (order_id, product_id, quantity, price, total) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void addOrderItemByOrderId(Long orderId,
                               Long productId,
                               Integer quantity,
                               Double price,
                               Double total);

    // add orderitem by product id
    @Modifying
    @Query(value = 
            "INSERT INTO order_item (order_id, product_id, quantity, price, total) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void addOrderItemByProductId(Long orderId,
                                 Long productId,
                                 Integer quantity,
                                 Double price,
                                 Double total);

    // add orderitem
    @Modifying
    @Query(value = 
            "INSERT INTO order_item (order_id, product_id, quantity, price, total) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void addOrderItem(Long orderId,
                      Long productId,
                      Integer quantity,
                      Double price,
                      Double total);

    // get all orderitems
    @Query(value = 
            "SELECT * " +
            "FROM order_item", nativeQuery = true)
    List<OrderItem> getAllOrderItems();

    // get all orderitems by order id
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "WHERE order_id = ?1", nativeQuery = true)
    List<OrderItem> getAllOrderItemsByOrderId(Long orderId);

    // get all orderitems by product id
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "WHERE product_id = ?1", nativeQuery = true)
    List<OrderItem> getAllOrderItemsByProductId(Long productId);

    // get all orderitems by order id and product id
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "WHERE order_id = ?1 " +
            "AND product_id = ?2", nativeQuery = true)
    List<OrderItem> getAllOrderItemsByOrderIdAndProductId(Long orderId, Long productId);

}
