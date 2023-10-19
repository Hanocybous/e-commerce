package com.hanocybous.ecommercesystem.service.product;

import com.hanocybous.ecommercesystem.dto.product.ProductDto;
import com.hanocybous.ecommercesystem.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean isProductExisting(Long id) {
        if (id == null) {
            return false;
        }
        return productRepository.existsById(id);
    }

    public List<ProductDto> getProductsByCategory(String category) {
        if (category == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByCategory(category);
    }

    public List<ProductDto> getProductsByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByName(name);
    }

    public List<ProductDto> getProductsByNameAndCategory(String name, String category) {
        if (name == null || category == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByNameAndCategory(name, category);
    }

    public List<ProductDto> getProductsByPrice(Double price) {
        if (price == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByPrice(price);
    }

    public List<ProductDto> getProductsByPriceAndCategory(Double price, String category) {
        if (price == null || category == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByPriceAndCategory(price, category);
    }

    public List<ProductDto> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        if (minPrice == null || maxPrice == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByPriceRange(minPrice, maxPrice);
    }

    public List<ProductDto> getProductsByPriceRangeAndCategory(Double minPrice, Double maxPrice, String category) {
        if (minPrice == null || maxPrice == null || category == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByPriceRangeAndCategory(minPrice, maxPrice, category);
    }

    public List<ProductDto> getProductsByQuantity(Integer quantity) {
        if (quantity == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByQuantity(quantity);
    }

    public List<ProductDto> getProductsByQuantityAndCategory(Integer quantity, String category) {
        if (quantity == null || category == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByQuantityAndCategory(quantity, category);
    }

    public List<ProductDto> getProductsByQuantityRange(Integer minQuantity, Integer maxQuantity) {
        if (minQuantity == null || maxQuantity == null) {
            return Collections.emptyList();
        }
        return productRepository.getProductsByQuantityRange(minQuantity, maxQuantity);
    }

}
