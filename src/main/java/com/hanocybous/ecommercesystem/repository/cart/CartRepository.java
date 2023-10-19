package com.hanocybous.ecommercesystem.repository.cart;

import com.hanocybous.ecommercesystem.dto.cart.CartDto;
import com.hanocybous.ecommercesystem.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "WHERE user_id = ?1", nativeQuery = true)
    List<CartDto> getCartByUserId(@Param("userId") Long userId);

    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "WHERE user_id = ?1 " +
            "AND product_id = ?2", nativeQuery = true)
    List<CartDto> getCartByUserIdAndProductId(@Param("userId") Long userId,
                                              @Param("productId") Long productId);

    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "WHERE user_id = ?1 " +
            "AND product_id = ?2 " , nativeQuery = true)
    List<CartDto> getCartByUserIdAndProductIdAndQuantity(@Param("userId") Long userId,
                                                         @Param("productId") Long productId);

    // get all carts sorted by total discount
    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "ORDER BY total_discount", nativeQuery = true)
    List<CartDto> getAllCartsSortedByTotalDiscount(@Param("totalDiscount") Double totalDiscount);

    // get all carts sorted by total shipping
    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "ORDER BY total_shipping", nativeQuery = true)
    List<CartDto> getAllCartsSortedByTotalShipping(@Param("totalShipping") Double totalShipping);

    // get all carts sorted by total price
    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "ORDER BY total_price", nativeQuery = true)
    List<CartDto> getAllCartsSortedByTotalPrice(@Param("totalPrice") Double totalPrice);

    // get all carts sorted by total amount
    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "ORDER BY total_amount", nativeQuery = true)
    List<CartDto> getAllCartsSortedByTotalAmount(@Param("totalAmount") Double totalAmount);

    // get all carts sorted by user id
    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "ORDER BY user_id", nativeQuery = true)
    List<CartDto> getAllCartsSortedByUserId(@Param("userId") Long userId);

    // get all carts sorted by product id
    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "ORDER BY product_id", nativeQuery = true)
    List<CartDto> getAllCartsSortedByProductId(@Param("productId") Long productId);

    // delete cart by user id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM cart " +
            "WHERE user_id = ?1", nativeQuery = true)
    void deleteCartByUserId(@Param("userId") Long userId);

    // delete cart by product id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM cart " +
            "WHERE product_id = ?1", nativeQuery = true)
    void deleteCartByProductId(@Param("productId") Long productId);

    // delete cart by user id and product id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM cart " +
            "WHERE user_id = ?1 " +
            "AND product_id = ?2", nativeQuery = true)
    void deleteCartByUserIdAndProductId(@Param("userId") Long userId,
                                        @Param("productId") Long productId);

    // add a cart by user id and product id
    @Modifying
    @Query(value =
            "INSERT INTO cart " +
            "VALUES (null, ?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void addCartByUserIdAndProductId(@Param("userId") Long userId,
                                     @Param("productId") Long productId,
                                     @Param("productName") String productName,
                                     @Param("productPrice") Double productPrice,
                                     @Param("quantity") Integer quantity,
                                     @Param("totalDiscount") Double totalDiscount,
                                     @Param("totalShipping") Double totalShipping,
                                     @Param("totalAmount") Double totalAmount);

    // update a cart by user id and product id
    @Modifying
    @Query(value =
            "UPDATE cart " +
            "SET total_discount = ?4, " +
            "total_shipping = ?5, " +
            "total_amount = ?6 " +
            "WHERE user_id = ?7 " +
            "AND product_id = ?8", nativeQuery = true)
    void updateCartByUserIdAndProductId(@Param("totalDiscount") Double totalDiscount,
                                        @Param("totalShipping") Double totalShipping,
                                        @Param("totalAmount") Double totalAmount,
                                        @Param("userId") Long userId,
                                        @Param("productId") Long productId);

    // update a cart by user id
    @Modifying
    @Query(value =
            "UPDATE cart " +
            "SET total_discount = ?4, " +
            "total_shipping = ?5, " +
            "total_amount = ?6 " +
            "WHERE user_id = ?7", nativeQuery = true)
    void updateCartByUserId(@Param("totalDiscount") Double totalDiscount,
                            @Param("totalShipping") Double totalShipping,
                            @Param("totalAmount") Double totalAmount,
                            @Param("userId") Long userId);

    // update a cart by product id
    @Modifying
    @Query(value =
            "UPDATE cart " +
            "SET total_discount = ?4, " +
            "total_shipping = ?5, " +
            "total_amount = ?6 " +
            "WHERE product_id = ?7", nativeQuery = true)
    void updateCartByProductId(@Param("totalDiscount") Double totalDiscount,
                               @Param("totalShipping") Double totalShipping,
                               @Param("totalAmount") Double totalAmount,
                               @Param("productId") Long productId);

    // update a cart by user id and product id and quantity
    @Modifying
    @Query(value =
            "UPDATE cart " +
            "SET quantity = ?4 " +
            "WHERE user_id = ?5 " +
            "AND product_id = ?6", nativeQuery = true)
    void updateCartByUserIdAndProductIdAndQuantity(@Param("quantity") Integer quantity,
                                                   @Param("userId") Long userId,
                                                   @Param("productId") Long productId);

    // get cart by user id and product id and quantity
    @Query(value =
            "SELECT * " +
            "FROM cart " +
            "WHERE user_id = ?1 " +
            "AND product_id = ?2 " +
            "AND quantity = ?3", nativeQuery = true)
    List<CartDto> getCartByUserIdAndProductIdAndQuantity(Long userId, Long productId, Integer quantity);

    // update a cart by product id and user id
    @Modifying
    @Query(value =
            "UPDATE cart " +
            "SET quantity = ?3 " +
            "WHERE product_id = ?1 " +
            "AND user_id = ?2", nativeQuery = true)
    void updateCartByProductIdAndUserId(Long productId, Long userId, Integer quantity);

    // delete cart by product id and user id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM cart " +
            "WHERE product_id = ?1 " +
            "AND user_id = ?2", nativeQuery = true)
    void deleteCartByProductIdAndUserId(Long productId, Long userId);
}
