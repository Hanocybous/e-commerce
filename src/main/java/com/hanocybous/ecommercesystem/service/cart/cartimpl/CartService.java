package com.hanocybous.ecommercesystem.service.cart.cartimpl;

import com.hanocybous.ecommercesystem.dto.cart.CartDto;
import com.hanocybous.ecommercesystem.entity.cart.Cart;
import com.hanocybous.ecommercesystem.entity.product.Product;
import com.hanocybous.ecommercesystem.repository.cart.CartRepository;
import com.hanocybous.ecommercesystem.service.cart.ICartService;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Getter
@SuppressWarnings("unused")
public class CartService implements ICartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // get cart by user id
    public List<CartDto> getCartByUserId(Long userId) {
        if (userId == null || userId < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getCartByUserId(userId);
    }

    // get cart by user id and product id
    public List<CartDto> getCartByUserIdAndProductId(Long userId, Long productId) {
        if (userId == null || userId < 0 || productId == null || productId < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getCartByUserIdAndProductId(userId, productId);
    }

    // get cart by user id and product id and quantity
    public List<CartDto> getCartByUserIdAndProductIdAndQuantity(Long userId, Long productId, Integer quantity) {
        if (userId == null || userId < 0 || productId == null || productId < 0 || quantity == null || quantity < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getCartByUserIdAndProductIdAndQuantity(userId, productId, quantity);
    }

    // get all carts sorted by total discount
    public List<CartDto> getAllCartsSortedByTotalDiscount(Double totalDiscount) {
        if (totalDiscount == null || totalDiscount < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getAllCartsSortedByTotalDiscount(totalDiscount);
    }

    // get all carts sorted by total price
    public List<CartDto> getAllCartsSortedByTotalPrice(Double totalPrice) {
        if (totalPrice == null || totalPrice < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getAllCartsSortedByTotalPrice(totalPrice);
    }

    // update cart by product id and user id
    public void updateCartByProductIdAndUserId(Long productId, Long userId, Integer quantity) {
        if (productId == null || productId < 0 || userId == null || userId < 0 || quantity == null || quantity < 0) {
            return;
        }
        cartRepository.updateCartByProductIdAndUserId(productId, userId, quantity);
    }

    // delete cart by product id and user id
    public void deleteCartByProductIdAndUserId(Long productId, Long userId) {
        if (productId == null || productId < 0 || userId == null || userId < 0) {
            return;
        }
        cartRepository.deleteCartByProductIdAndUserId(productId, userId);
    }

    // delete cart by user id
    public void deleteCartByUserId(Long userId) {
        if (userId == null || userId < 0) {
            return;
        }
        cartRepository.deleteCartByUserId(userId);
    }

    // delete cart by product id
    public void deleteCartByProductId(Long productId) {
        if (productId == null || productId < 0) {
            return;
        }
        cartRepository.deleteCartByProductId(productId);
    }

    // add cart
    public void addCart(@NotNull Cart cart) {
        cartRepository.save(cart);
    }

    // get all carts sorted by total shipping
    public List<CartDto> getAllCartsSortedByTotalShipping(Double totalShipping) {
        if (totalShipping == null || totalShipping < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getAllCartsSortedByTotalShipping(totalShipping);
    }

    // get all carts sorted by total amount
    public List<CartDto> getAllCartsSortedByTotalAmount(Double totalAmount) {
        if (totalAmount == null || totalAmount < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getAllCartsSortedByTotalAmount(totalAmount);
    }

    // get all carts sorted by user id
    public List<CartDto> getAllCartsSortedByUserId(Long userId) {
        if (userId == null || userId < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getAllCartsSortedByUserId(userId);
    }

    // get all carts sorted by product id
    public List<CartDto> getAllCartsSortedByProductId(Long productId) {
        if (productId == null || productId < 0) {
            return Collections.emptyList();
        }
        return cartRepository.getAllCartsSortedByProductId(productId);
    }

    // delete cart by user id and product id
    public void deleteCartByUserIdAndProductId(Long userId, Long productId) {
        if (userId == null || userId < 0 || productId == null || productId < 0) {
            return;
        }
        cartRepository.deleteCartByUserIdAndProductId(userId, productId);
    }

    public void addProductToCart(@NotNull Cart cart, Product product) {
        if (product == null) {
            return;
        }
        cart.addProduct(product);
    }

    public void removeProductFromCart(Cart cart, Product product) {
        if (product == null) {
            return;
        }
        cart.removeProduct(product);
    }

    public double getTotalPrice(Cart cart) {
        return cart.getProducts().stream().mapToDouble(Product::getPrice).sum();
    }
}
