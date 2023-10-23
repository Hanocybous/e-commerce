package com.hanocybous.ecommercesystem.controller.cart;

import com.hanocybous.ecommercesystem.dto.cart.CartDto;
import com.hanocybous.ecommercesystem.entity.cart.Cart;

import java.util.List;

public interface ICartController {

    List<CartDto> getCartByUserId(Long userId);

    List<CartDto> getCartByUserIdAndProductId(Long userId, Long productId);

    void addCart(Cart cart);

    void updateCartByProductIdAndUserId(Long productId, Long userId, Integer quantity);

    void deleteCartByProductIdAndUserId(Long productId, Long userId);

    void deleteCartByProductId(Long productId);

    void deleteCartByUserId(Long userId);

    void deleteCartByUserIdAndProductId(Long userId, Long productId);
    
}
