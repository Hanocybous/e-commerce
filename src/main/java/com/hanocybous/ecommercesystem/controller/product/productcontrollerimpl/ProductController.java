package com.hanocybous.ecommercesystem.controller.product.productcontrollerimpl;

import com.hanocybous.ecommercesystem.controller.product.IProductController;
import com.hanocybous.ecommercesystem.dto.product.ProductDto;
import com.hanocybous.ecommercesystem.service.product.productimpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/product")
public class ProductController implements IProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/isProductExisting/{id}")
    public boolean isProductExisting(
            @RequestBody
            @PathVariable Long id) {
        return productService.isProductExisting(id);
    }

    @GetMapping("/getProductsByCategory/{category}")
    public List<ProductDto> getProductsByCategory(
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/getProductsByName/{name}")
    public List<ProductDto> getProductsByName(
            @RequestBody
            @PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/getProductsByNameAndCategory/{name}/{category}")
    public List<ProductDto> getProductsByNameAndCategory(
            @RequestBody
            @PathVariable String name,
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByNameAndCategory(name, category);
    }

    @GetMapping("/getProductsByPrice/{price}")
    public List<ProductDto> getProductsByPrice(
            @RequestBody
            @PathVariable Double price) {
        return productService.getProductsByPrice(price);
    }

    @GetMapping("/getProductsByPriceAndCategory/{price}/{category}")
    public List<ProductDto> getProductsByPriceAndCategory(
            @RequestBody
            @PathVariable Double price,
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByPriceAndCategory(price, category);
    }

    @GetMapping("/getProductsByPriceRange/{minPrice}/{maxPrice}")
    public List<ProductDto> getProductsByPriceRange(
            @RequestBody
            @PathVariable Double minPrice,
            @RequestBody
            @PathVariable Double maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/getProductsByPriceRangeAndCategory/{minPrice}/{maxPrice}/{category}")
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
    public List<ProductDto> getProductsByQuantity(
            @RequestBody
            @PathVariable Integer quantity) {
        return productService.getProductsByQuantity(quantity);
    }

    @GetMapping("/getProductsByQuantityAndCategory/{quantity}/{category}")
    public List<ProductDto> getProductsByQuantityAndCategory(
            @RequestBody
            @PathVariable Integer quantity,
            @RequestBody
            @PathVariable String category) {
        return productService.getProductsByQuantityAndCategory(quantity, category);
    }

    @GetMapping("/getAllProductsSortedByPrice/{price}")
    public List<ProductDto> getAllProductsSortedByPrice(
            @RequestBody
            @PathVariable Double price) {
        return productService.getAllProductsSortedByPrice(price);
    }

    @GetMapping("/getAllProductsSortedByQuantity/{quantity}")
    public List<ProductDto> getAllProductsSortedByQuantity(
            @RequestBody
            @PathVariable Integer quantity) {
        return productService.getAllProductsSortedByQuantity(quantity);
    }

    @GetMapping("/getAllProductsSortedByName/{name}")
    public List<ProductDto> getAllProductsSortedByName(
            @RequestBody
            @PathVariable String name) {
        return productService.getAllProductsSortedByName(name);
    }

    @GetMapping("/getAllProductsSortedByCategory/{category}")
    public List<ProductDto> getAllProductsSortedByCategory(
            @RequestBody
            @PathVariable String category) {
        return productService.getAllProductsSortedByCategory(category);
    }

    @GetMapping("/getAllProductsSortedByPriceRange/{minPrice}/{maxPrice}")
    public List<ProductDto> getAllProductsSortedByPriceRange(
            @RequestBody
            @PathVariable Double minPrice,
            @RequestBody
            @PathVariable Double maxPrice) {
        return productService.getAllProductsSortedByPriceRange(minPrice, maxPrice);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public void deleteProductById(
            @RequestBody
            @PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @DeleteMapping("/deleteProductByName/{name}")
    public void deleteProductByName(
            @RequestBody
            @PathVariable String name) {
        productService.deleteProductByName(name);
    }

    @DeleteMapping("/deleteProductByCategory/{category}")
    public void deleteProductByCategory(
            @RequestBody
            @PathVariable String category) {
        productService.deleteProductByCategory(category);
    }

    @DeleteMapping("/deleteProductByPrice/{price}")
    public void deleteProductByPrice(
            @RequestBody
            @PathVariable Double price) {
        productService.deleteProductByPrice(price);
    }

    @DeleteMapping("/deleteProductByQuantity/{quantity}")
    public void deleteProductByQuantity(
            @RequestBody
            @PathVariable Integer quantity) {
        productService.deleteProductByQuantity(quantity);
    }

    @PutMapping("/updateProductById/{id}")
    public void updateProductById(
            @RequestBody
            @PathVariable Long id,
            @RequestBody ProductDto productDto) {
        productService.updateProductById(id, productDto);
    }

    @PutMapping("/updateProductByName/{name}")
    public void updateProductByName(
            @RequestBody
            @PathVariable String name,
            @RequestBody ProductDto productDto) {
        productService.updateProductByName(name, productDto);
    }

    @PutMapping("/updateProductByCategory/{category}")
    public void updateProductByCategory(
            @RequestBody
            @PathVariable String category,
            @RequestBody ProductDto productDto) {
        productService.updateProductByCategory(category, productDto);
    }

}
