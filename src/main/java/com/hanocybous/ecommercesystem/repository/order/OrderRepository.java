package com.hanocybous.ecommercesystem.repository.order;

import com.hanocybous.ecommercesystem.dto.order.OrderDto;
import com.hanocybous.ecommercesystem.entity.order.EOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface OrderRepository extends JpaRepository<EOrder, Long> {


    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE id = :id", nativeQuery = true)
    List<OrderDto> getOrderById(@Param("id") Long id);

    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE user_id = :userId", nativeQuery = true)
    List<OrderDto> getOrderByUserId(@Param("userId") Long userId);

    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE user_id = :userId " +
            "AND status = :status", nativeQuery = true)
    List<OrderDto> getOrderByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);

    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE user_id = :userId " +
            "AND status = :status " +
            "AND id = :id", nativeQuery = true)
    List<OrderDto> getOrderByUserIdAndStatusAndId(@Param("userId") Long userId,
                                         @Param("status") String status,
                                         @Param("id") Long id);

    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE user_id = :userId " +
            "AND status = :status " +
            "AND id = :id " +
            "AND payment_method = :paymentMethod", nativeQuery = true)
    List<OrderDto> getOrderByUserIdAndStatusAndIdAndPaymentMethod(@Param("userId") Long userId,
                                                         @Param("status") String status,
                                                         @Param("id") Long id,
                                                         @Param("paymentMethod") String paymentMethod);

    // sort all orders by order date
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "ORDER BY order_date DESC", nativeQuery = true)
    List<OrderDto> getAllOrdersByOrderDate();

    // sort all orders by order date and status
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE status = :status " +
            "ORDER BY order_date DESC", nativeQuery = true)
    List<OrderDto> getAllOrdersByOrderDateAndStatus(@Param("status") String status);

    // sort all orders by order date and payment method
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE payment_method = :paymentMethod " +
            "ORDER BY order_date DESC", nativeQuery = true)
    List<OrderDto> getAllOrdersByOrderDateAndPaymentMethod(@Param("paymentMethod") String paymentMethod);

    // sort all orders by payment method
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE payment_method = :paymentMethod " +
            "ORDER BY order_date DESC", nativeQuery = true)
    List<OrderDto> getAllOrdersByPaymentMethod(@Param("paymentMethod") String paymentMethod);

    // sort all orders by status
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE status = :status " +
            "ORDER BY order_date DESC", nativeQuery = true)
    List<OrderDto> getAllOrdersByStatus(@Param("status") String status);

    // get all orders from a shipping address without ordering them
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE shipping_address = :shippingAddress", nativeQuery = true)
    List<OrderDto> getAllOrdersByShippingAddress(@Param("shippingAddress") String shippingAddress);

    // get all orders from a shipping address and sort them by order date
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE shipping_address = :shippingAddress " +
            "ORDER BY order_date DESC", nativeQuery = true)
    List<OrderDto> getAllOrdersByShippingAddressAndOrderDate(@Param("shippingAddress") String shippingAddress);

    // get all orders by total amount
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE total_amount = :totalAmount", nativeQuery = true)
    List<OrderDto> getAllOrdersByTotalAmount(@Param("totalAmount") Double totalAmount);

    // get all orders by total amount and sort them by order date
    @Query(value = 
            "SELECT * " +
            "FROM orders " +
            "WHERE total_amount = :totalAmount " +
            "ORDER BY order_date DESC", nativeQuery = true)
    List<OrderDto> getAllOrdersByTotalAmountAndOrderDate(@Param("totalAmount") Double totalAmount);

    // get all orderitems from an order
    @Query(value = 
            "SELECT * " +
            "FROM order_item " +
            "WHERE order_id = :orderId", nativeQuery = true)
    List<OrderDto> getAllOrderItemsByOrderId(@Param("orderId") Long orderId);
    
    // delete all orderitems from an order
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM order_item " +
            "WHERE order_id = :orderId", nativeQuery = true)
    void deleteAllOrderItemsByOrderId(@Param("orderId") Long orderId);

    // delete order by id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE id = :id", nativeQuery = true)
    void deleteOrderById(@Param("id") Long id);

    // delete order by user id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE user_id = :userId", nativeQuery = true)
    void deleteOrderByUserId(@Param("userId") Long userId);

    // delete order by user id and status
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE user_id = :userId " +
            "AND status = :status", nativeQuery = true)
    void deleteOrderByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);

    // delete order by user id and status and id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE user_id = :userId " +
            "AND status = :status " +
            "AND id = :id", nativeQuery = true)
    void deleteOrderByUserIdAndStatusAndId(@Param("userId") Long userId,
                                           @Param("status") String status,
                                           @Param("id") Long id);

    // delete all orders within a specific date range
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE order_date BETWEEN :startDate AND :endDate", nativeQuery = true)
    void deleteAllOrdersByOrderDateBetween(@Param("startDate") String startDate,
                                           @Param("endDate") String endDate);

    // delete all orders within a specific date range and status
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE order_date BETWEEN :startDate AND :endDate " +
            "AND status = :status", nativeQuery = true)
    void deleteAllOrdersByOrderDateBetweenAndStatus(@Param("startDate") String startDate,
                                                    @Param("endDate") String endDate,
                                                    @Param("status") String status);

    // delete all orders within a specific date range and payment method
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE order_date BETWEEN :startDate AND :endDate " +
            "AND payment_method = :paymentMethod", nativeQuery = true)
    void deleteAllOrdersByOrderDateBetweenAndPaymentMethod(@Param("startDate") String startDate,
                                                           @Param("endDate") String endDate,
                                                           @Param("paymentMethod") String paymentMethod);

    // add an order
    @Modifying
    @Query(value =
            "INSERT INTO orders (user_id, order_date, status, shipping_address, payment_method, total_amount) " +
            "VALUES (:userId, :orderDate, :status, :shippingAddress, :paymentMethod, :totalAmount)", nativeQuery = true)
    void addOrder(@Param("userId") Long userId,
                  @Param("orderDate") String orderDate,
                  @Param("status") String status,
                  @Param("shippingAddress") String shippingAddress,
                  @Param("paymentMethod") String paymentMethod,
                  @Param("totalAmount") Double totalAmount);

    // update an order by id
    @Modifying
    @Query(value =
            "UPDATE orders " +
            "SET user_id = :userId, " +
            "order_date = :orderDate, " +
            "status = :status, " +
            "shipping_address = :shippingAddress, " +
            "payment_method = :paymentMethod, " +
            "total_amount = :totalAmount " +
            "WHERE id = :id", nativeQuery = true)
    void updateOrderById(@Param("id") Long id,
                         @Param("userId") Long userId,
                         @Param("orderDate") String orderDate,
                         @Param("status") String status,
                         @Param("shippingAddress") String shippingAddress,
                         @Param("paymentMethod") String paymentMethod,
                         @Param("totalAmount") Double totalAmount);

    // update an order by user id
    @Modifying
    @Query(value =
            "UPDATE orders " +
            "SET user_id = :newUserId " +
            "WHERE user_id = :userId", nativeQuery = true)
    void updateOrderByUserId(@Param("userId") Long userId,
                             @Param("newUserId") Long newUserId);

    // update an order by user id and status
    @Modifying
    @Query(value =
            "UPDATE orders " +
            "SET user_id = :newUserId, " +
            "status = :newStatus " +
            "WHERE user_id = :userId " +
            "AND status = :status", nativeQuery = true)
    void updateOrderByUserIdAndStatus(@Param("userId") Long userId,
                                      @Param("status") String status,
                                      @Param("newUserId") Long newUserId,
                                      @Param("newStatus") String newStatus);

    // get order by product id
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id = :productId)", nativeQuery = true)
    List<OrderDto> getOrderByProductId(Long productId);

    // get order by product id and status
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id = :productId) " +
            "AND status = :status", nativeQuery = true)
    List<OrderDto> getOrderByProductIdAndStatus(@Param("productId") Long productId,
                                                @Param("status") String status);

    // get order by product id and status and id
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id = :productId) " +
            "AND status = :status " +
            "AND id = :id", nativeQuery = true)
    List<OrderDto> getOrderByProductIdAndStatusAndId(@Param("productId") Long productId,
                                                     @Param("status") String status,
                                                     @Param("id") Long id);

    // get order by product name
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id IN " +
            "(SELECT id " +
            "FROM product " +
            "WHERE name = :productName))", nativeQuery = true)
    List<OrderDto> getOrderByProductName(@Param("productName") String productName);

    // get order by product name and status
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id IN " +
            "(SELECT id " +
            "FROM product " +
            "WHERE name = :productName)) " +
            "AND status = :status", nativeQuery = true)
    List<OrderDto> getOrderByProductNameAndStatus(@Param("productName") String productName,
                                                   @Param("status") String status);

    // get order by product name and status and id
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id IN " +
            "(SELECT id " +
            "FROM product " +
            "WHERE name = :productName)) " +
            "AND status = :status " +
            "AND id = :id", nativeQuery = true)
    List<OrderDto> getOrderByProductNameAndStatusAndId(@Param("productName") String productName,
                                                        @Param("status") String status,
                                                        @Param("id") Long id);

    // get order by category
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id IN " +
            "(SELECT id " +
            "FROM product " +
            "WHERE category = :category))", nativeQuery = true)
    List<OrderDto> getOrderByCategory(@Param("category") String category);

    // get order by category and status
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id IN " +
            "(SELECT id " +
            "FROM product " +
            "WHERE category = :category)) " +
            "AND status = :status", nativeQuery = true)
    List<OrderDto> getOrderByCategoryAndStatus(@Param("category") String category,
                                                @Param("status") String status);

    // get order by category and status and id
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id IN " +
            "(SELECT id " +
            "FROM product " +
            "WHERE category = :category)) " +
            "AND status = :status " +
            "AND id = :id", nativeQuery = true)
    List<OrderDto> getOrderByCategoryAndStatusAndId(@Param("category") String category,
                                                     @Param("status") String status,
                                                     @Param("id") Long id);

    // get order by total amount
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE total_amount = :totalAmount", nativeQuery = true)
    List<OrderDto> getOrderByTotalAmount(@Param("totalAmount") Double totalAmount);

    // get order by total shipping
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE total_shipping = :totalShipping", nativeQuery = true)
    List<OrderDto> getOrderByTotalShipping(@Param("totalShipping") Double totalShipping);

    // get order by total amount and total shipping
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE total_amount = :totalAmount " +
            "AND total_shipping = :totalShipping", nativeQuery = true)
    List<OrderDto> getOrderByTotalAmountAndTotalShipping(@Param("totalAmount") Double totalAmount,
                                                         @Param("totalShipping") Double totalShipping);

    // get order by user id and product id
    @Query(value =
            "SELECT * " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id = :productId) " +
            "AND user_id = :userId", nativeQuery = true)
    void getOrderByUserIdAndProductId(Long userId, Long productId);

    // delete order by product id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id = :productId)", nativeQuery = true)
    void deleteOrderByProductId(Long productId);

    // delete order by user id and product id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id = :productId) " +
            "AND user_id = :userId", nativeQuery = true)
    void deleteOrderByUserIdAndProductId(Long userId, Long productId);

    // delete all orders by user id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE user_id = :userId", nativeQuery = true)
    void deleteAllOrdersByUserId(Long userId);

    // delete all orders by product id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM orders " +
            "WHERE id IN " +
            "(SELECT order_id " +
            "FROM order_item " +
            "WHERE product_id = :productId)", nativeQuery = true)
    void deleteAllOrdersByProductId(Long productId);

}
