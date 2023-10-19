package com.hanocybous.ecommercesystem.service.product;

import com.hanocybous.ecommercesystem.dto.product.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getProductsByCategory(String category);

    List<ProductDto> getProductsByName(String name);

    List<ProductDto> getProductsByNameAndCategory(String name, String category);

    List<ProductDto> getProductsByPrice(Double price);

    List<ProductDto> getProductsByPriceAndCategory(Double price, String category);

    boolean isProductExisting(Long id);

}
