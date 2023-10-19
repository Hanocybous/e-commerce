package com.hanocybous.ecommercesystem.service.cart;

import com.hanocybous.ecommercesystem.dto.cart.CartDto;
import com.hanocybous.ecommercesystem.entity.cart.Cart;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ICartService {

    List<CartDto> getCartByUserId(Long userId);

    List<CartDto> getCartByUserIdAndProductId(Long userId, Long productId);

    List<CartDto> getCartByUserIdAndProductIdAndQuantity(Long userId, Long productId, Integer quantity);

    List<CartDto> getAllCartsSortedByTotalDiscount(Double totalDiscount);

    List<CartDto> getAllCartsSortedByTotalPrice(Double totalPrice);

    void updateCartByProductIdAndUserId(Long productId, Long userId, Integer quantity);

    void deleteCartByProductIdAndUserId(Long productId, Long userId);

    void deleteCartByUserId(Long userId);

    void deleteCartByProductId(Long productId);

    void addCart(@NotNull Cart cart);

}
