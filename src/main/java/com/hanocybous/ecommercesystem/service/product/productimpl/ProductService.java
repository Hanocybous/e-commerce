package com.hanocybous.ecommercesystem.service.product.productimpl;

import com.hanocybous.ecommercesystem.dto.product.ProductDto;
import com.hanocybous.ecommercesystem.entity.product.Product;
import com.hanocybous.ecommercesystem.repository.product.ProductRepository;
import com.hanocybous.ecommercesystem.service.product.IProductService;
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

    public List<ProductDto> getAllProductsSortedByPrice(Double price) {
        if (price == null) {
            return Collections.emptyList();
        }
        return productRepository.getAllProductsSortedByPrice(price);
    }

    public List<ProductDto> getAllProductsSortedByQuantity(Integer quantity) {
        if (quantity == null) {
            return Collections.emptyList();
        }
        return productRepository.getAllProductsSortedByQuantity(quantity);
    }

    public List<ProductDto> getAllProductsSortedByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }
        return productRepository.getAllProductsSortedByName(name);
    }

    public List<ProductDto> getAllProductsSortedByCategory(String category) {
        if (category == null) {
            return Collections.emptyList();
        }
        return productRepository.getAllProductsSortedByCategory(category);
    }

    public List<ProductDto> getAllProductsSortedByPriceRange(Double minPrice, Double maxPrice) {
        if (minPrice == null || maxPrice == null) {
            return Collections.emptyList();
        }
        return productRepository.getAllProductsSortedByPriceRange(minPrice, maxPrice);
    }

    public void deleteProductById(Long id) {
        if (id == null) {
            return;
        }
        productRepository.deleteById(id);
    }

    public void deleteProductByName(String name) {
        if (name == null) {
            return;
        }
        productRepository.deleteProductByName(name);
    }

    public void deleteProductByCategory(String category) {
        if (category == null) {
            return;
        }
        productRepository.deleteProductByCategory(category);
    }

    public void deleteProductByPrice(Double price) {
        if (price == null) {
            return;
        }
        productRepository.deleteProductByPrice(price);
    }

    public void deleteProductByQuantity(Integer quantity) {
        if (quantity == null) {
            return;
        }
        productRepository.deleteProductByQuantity(quantity);
    }

    public void updateProductById(Long id, ProductDto productDto) {
        if (id == null || productDto == null) {
            return;
        }
        productRepository.updateProductById(id, productDto);
    }

    public void updateProductByName(String name, ProductDto productDto) {
        if (name == null || productDto == null) {
            return;
        }
        productRepository.updateProductByName(name, productDto);
    }

    public void updateProductByCategory(String category, ProductDto productDto) {
        if (category == null || productDto == null) {
            return;
        }
        productRepository.updateProductByCategory(category, productDto);
    }


    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        productRepository.save(product);
    }
}
