package com.hanocybous.ecommercesystem.controller;

import com.hanocybous.ecommercesystem.dto.product.ProductDto;
import com.hanocybous.ecommercesystem.service.product.productimpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/isProductExisting/{id}")
    @ResponseBody
    public boolean isProductExisting(
            @RequestBody
            @PathVariable Long id) {
        return productService.isProductExisting(id);
    }

    @GetMapping("/getProductsByCategory/{category}")
    @ResponseBody
    public List<ProductDto> getProductsByCategory(
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/getProductsByName/{name}")
    @ResponseBody
    public List<ProductDto> getProductsByName(
            @RequestBody
            @PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/getProductsByNameAndCategory/{name}/{category}")
    @ResponseBody
    public List<ProductDto> getProductsByNameAndCategory(
            @RequestBody
            @PathVariable String name,
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByNameAndCategory(name, category);
    }

    @GetMapping("/getProductsByPrice/{price}")
    @ResponseBody
    public List<ProductDto> getProductsByPrice(
            @RequestBody
            @PathVariable Double price) {
        return productService.getProductsByPrice(price);
    }

    @GetMapping("/getProductsByPriceAndCategory/{price}/{category}")
    @ResponseBody
    public List<ProductDto> getProductsByPriceAndCategory(
            @RequestBody
            @PathVariable Double price,
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByPriceAndCategory(price, category);
    }

    @GetMapping("/getProductsByPriceRange/{minPrice}/{maxPrice}")
    @ResponseBody
    public List<ProductDto> getProductsByPriceRange(
            @RequestBody
            @PathVariable Double minPrice,
            @RequestBody
            @PathVariable Double maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/getProductsByPriceRangeAndCategory/{minPrice}/{maxPrice}/{category}")
    @ResponseBody
    public List<ProductDto> getProductsByPriceRangeAndCategory(
            @RequestBody
            @PathVariable Double minPrice,
            @RequestBody
            @PathVariable Double maxPrice,
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByPriceRangeAndCategory(minPrice, maxPrice, category);
    }

    @GetMapping("/getProductsByQuantity/{quantity}")
    @ResponseBody
    public List<ProductDto> getProductsByQuantity(
            @RequestBody
            @PathVariable Integer quantity) {
        return productService.getProductsByQuantity(quantity);
    }

    @GetMapping("/getProductsByQuantityAndCategory/{quantity}/{category}")
    @ResponseBody
    public List<ProductDto> getProductsByQuantityAndCategory(
            @RequestBody
            @PathVariable Integer quantity,
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByQuantityAndCategory(quantity, category);
    }

    @GetMapping("/getAllProductsSortedByPrice/{price}")
    @ResponseBody
    public List<ProductDto> getAllProductsSortedByPrice(
            @RequestBody
            @PathVariable Double price) {
        return productService.getAllProductsSortedByPrice(price);
    }

    @GetMapping("/getAllProductsSortedByQuantity/{quantity}")
    @ResponseBody
    public List<ProductDto> getAllProductsSortedByQuantity(
            @RequestBody
            @PathVariable Integer quantity) {
        return productService.getAllProductsSortedByQuantity(quantity);
    }

    @GetMapping("/getAllProductsSortedByName/{name}")
    @ResponseBody
    public List<ProductDto> getAllProductsSortedByName(
            @RequestBody
            @PathVariable String name) {
        return productService.getAllProductsSortedByName(name);
    }

    @GetMapping("/getAllProductsSortedByCategory/{category}")
    @ResponseBody
    public List<ProductDto> getAllProductsSortedByCategory(
            @RequestBody
            @PathVariable String category) {
        return productService.getAllProductsSortedByCategory(category);
    }

    @GetMapping("/getAllProductsSortedByPriceRange/{minPrice}/{maxPrice}")
    @ResponseBody
    public List<ProductDto> getAllProductsSortedByPriceRange(
            @RequestBody
            @PathVariable Double minPrice,
            @RequestBody
            @PathVariable Double maxPrice) {
        return productService.getAllProductsSortedByPriceRange(minPrice, maxPrice);
    }

    @DeleteMapping("/deleteProductById/{id}")
    @ResponseBody
    public void deleteProductById(
            @RequestBody
            @PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @DeleteMapping("/deleteProductByName/{name}")
    @ResponseBody
    public void deleteProductByName(
            @RequestBody
            @PathVariable String name) {
        productService.deleteProductByName(name);
    }

    @DeleteMapping("/deleteProductByCategory/{category}")
    @ResponseBody
    public void deleteProductByCategory(
            @RequestBody
            @PathVariable String category) {
        productService.deleteProductByCategory(category);
    }

    @DeleteMapping("/deleteProductByPrice/{price}")
    @ResponseBody
    public void deleteProductByPrice(
            @RequestBody
            @PathVariable Double price) {
        productService.deleteProductByPrice(price);
    }

    @DeleteMapping("/deleteProductByQuantity/{quantity}")
    @ResponseBody
    public void deleteProductByQuantity(
            @RequestBody
            @PathVariable Integer quantity) {
        productService.deleteProductByQuantity(quantity);
    }

    @PutMapping("/updateProductById/{id}")
    @ResponseBody
    public void updateProductById(
            @RequestBody
            @PathVariable Long id,
            @RequestBody ProductDto productDto) {
        productService.updateProductById(id, productDto);
    }

    @PutMapping("/updateProductByName/{name}")
    @ResponseBody
    public void updateProductByName(
            @RequestBody
            @PathVariable String name,
            @RequestBody ProductDto productDto) {
        productService.updateProductByName(name, productDto);
    }

    @PutMapping("/updateProductByCategory/{category}")
    @ResponseBody
    public void updateProductByCategory(
            @RequestBody
            @PathVariable String category,
            @RequestBody ProductDto productDto) {
        productService.updateProductByCategory(category, productDto);
    }

}
