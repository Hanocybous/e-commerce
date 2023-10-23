package com.hanocybous.ecommercesystem.controller.product;

import com.hanocybous.ecommercesystem.dto.product.ProductDto;

import java.util.List;

public interface IProductController {

    boolean isProductExisting(Long id);

    List<ProductDto> getProductsByCategory(String category);

    List<ProductDto> getProductsByName(String name);

    List<ProductDto> getProductsByNameAndCategory(String name, String category);

    List<ProductDto> getProductsByPrice(Double price);

    void deleteProductById(Long id);

    void deleteProductByName(String name);

    void updateProductById(Long id, ProductDto productDto);

    void updateProductByName(String name, ProductDto productDto);

}
