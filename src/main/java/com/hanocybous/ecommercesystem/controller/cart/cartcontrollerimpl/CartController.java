package com.hanocybous.ecommercesystem.controller.cart.cartcontrollerimpl;

import com.hanocybous.ecommercesystem.controller.cart.ICartController;
import com.hanocybous.ecommercesystem.dto.cart.CartDto;
import com.hanocybous.ecommercesystem.entity.cart.Cart;
import com.hanocybous.ecommercesystem.service.cart.cartimpl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/cart")
public class CartController implements ICartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getCartByUserId/{userId}")
    @ResponseBody
    public List<CartDto> getCartByUserId(
            @RequestBody
            @PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @GetMapping("/getCartByUserIdAndProductId/{userId}/{productId}")
    @ResponseBody
    public List<CartDto> getCartByUserIdAndProductId(
            @RequestBody
            @PathVariable Long userId,
            @RequestBody
            @PathVariable Long productId) {
        return cartService.getCartByUserIdAndProductId(userId, productId);
    }

    @GetMapping("/getCartByUserIdAndProductIdAndQuantity/{userId}/{productId}/{quantity}")
    @ResponseBody
    public List<CartDto> getCartByUserIdAndProductIdAndQuantity(
            @RequestBody
            @PathVariable Long userId,
            @RequestBody
            @PathVariable Long productId,
            @RequestBody
            @PathVariable Integer quantity) {
        return cartService.getCartByUserIdAndProductIdAndQuantity(userId, productId, quantity);
    }

    @GetMapping("/getAllCartsSortedByTotalDiscount/{totalDiscount}")
    @ResponseBody
    public List<CartDto> getAllCartsSortedByTotalDiscount(
            @RequestBody
            @PathVariable Double totalDiscount) {
        return cartService.getAllCartsSortedByTotalDiscount(totalDiscount);
    }

    @PostMapping("/addCart")
    @ResponseBody
    public void addCart(
            @RequestBody
            @RequestParam Cart cart) {
        cartService.addCart(cart);
    }

    @PutMapping("/updateCartByProductIdAndUserId/{productId}/{userId}/{quantity}")
    @ResponseBody
    public void updateCartByProductIdAndUserId(
            @RequestBody
            @PathVariable Long productId,
            @RequestBody
            @PathVariable Long userId,
            @RequestBody
            @PathVariable Integer quantity) {
        cartService.updateCartByProductIdAndUserId(productId, userId, quantity);
    }

    @DeleteMapping("/deleteCartByProductIdAndUserId/{productId}/{userId}")
    @ResponseBody
    public void deleteCartByProductIdAndUserId(
            @RequestBody
            @PathVariable Long productId,
            @RequestBody
            @PathVariable Long userId) {
        cartService.deleteCartByProductIdAndUserId(productId, userId);
    }

    @DeleteMapping("/deleteCartByUserId/{userId}")
    @ResponseBody
    public void deleteCartByUserId(
            @RequestBody
            @PathVariable Long userId) {
        cartService.deleteCartByUserId(userId);
    }

    @DeleteMapping("/deleteCartByProductId/{productId}")
    @ResponseBody
    public void deleteCartByProductId(
            @RequestBody
            @PathVariable Long productId) {
        cartService.deleteCartByProductId(productId);
    }

    @DeleteMapping("/deleteCartByUserIdAndProductId/{userId}/{productId}")
    @ResponseBody
    public void deleteCartByUserIdAndProductId(
            @RequestBody
            @PathVariable Long userId,
            @RequestBody
            @PathVariable Long productId) {
        cartService.deleteCartByUserIdAndProductId(userId, productId);
    }

    @GetMapping("/getAllCartsSortedByTotalPrice/{totalPrice}")
    @ResponseBody
    public List<CartDto> getAllCartsSortedByTotalPrice(
            @RequestBody
            @PathVariable Double totalPrice) {
        return cartService.getAllCartsSortedByTotalPrice(totalPrice);
    }

    @GetMapping("/getAllCartsSortedByTotalShipping/{totalShipping}")
    @ResponseBody
    public List<CartDto> getAllCartsSortedByTotalShipping(
            @RequestBody
            @PathVariable Double totalShipping) {
        return cartService.getAllCartsSortedByTotalShipping(totalShipping);
    }

    @GetMapping("/getAllCartsSortedByTotalAmount/{totalAmount}")
    @ResponseBody
    public List<CartDto> getAllCartsSortedByTotalAmount(
            @RequestBody
            @PathVariable Double totalAmount) {
        return cartService.getAllCartsSortedByTotalAmount(totalAmount);
    }

    @GetMapping("/getAllCartsSortedByUserId/{userId}")
    @ResponseBody
    public List<CartDto> getAllCartsSortedByUserId(
            @RequestBody
            @PathVariable Long userId) {
        return cartService.getAllCartsSortedByUserId(userId);
    }

    @GetMapping("/getAllCartsSortedByProductId/{productId}")
    @ResponseBody
    public List<CartDto> getAllCartsSortedByProductId(
            @RequestBody
            @PathVariable Long productId) {
        return cartService.getAllCartsSortedByProductId(productId);
    }

}
