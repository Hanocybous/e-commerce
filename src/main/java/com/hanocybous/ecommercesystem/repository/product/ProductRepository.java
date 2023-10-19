package com.hanocybous.ecommercesystem.repository.product;

import com.hanocybous.ecommercesystem.dto.product.ProductDto;
import com.hanocybous.ecommercesystem.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE category = ?1", nativeQuery = true)
    List<ProductDto> getProductsByCategory(@Param("category") String category);

    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE name = ?1", nativeQuery = true)
    List<ProductDto> getProductsByName(@Param("name") String name);

    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE name = ?1 " +
            "AND category = ?2", nativeQuery = true)
    List<ProductDto> getProductsByNameAndCategory(@Param("name") String name,
                                                  @Param("category") String category);

    // get product by price
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE price = ?1", nativeQuery = true)
    List<ProductDto> getProductsByPrice(@Param("price") Double price);

    // get product by price and category
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE price = ?1 " +
            "AND category = ?2", nativeQuery = true)
    List<ProductDto> getProductsByPriceAndCategory(@Param("price") Double price,
                                                   @Param("category") String category);

    // get product by price range
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE price >= ?1 " +
            "AND price <= ?2", nativeQuery = true)
    List<ProductDto> getProductsByPriceRange(@Param("minPrice") Double minPrice,
                                             @Param("maxPrice") Double maxPrice);

    // get product by price range and category
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE price >= ?1 " +
            "AND price <= ?2 " +
            "AND category = ?3", nativeQuery = true)
    List<ProductDto> getProductsByPriceRangeAndCategory(@Param("minPrice") Double minPrice,
                                                        @Param("maxPrice") Double maxPrice,
                                                        @Param("category") String category);

    // get product by quantity
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE quantity = ?1", nativeQuery = true)
    List<ProductDto> getProductsByQuantity(@Param("quantity") Integer quantity);

    // get product by quantity and category
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE quantity = ?1 " +
            "AND category = ?2", nativeQuery = true)
    List<ProductDto> getProductsByQuantityAndCategory(@Param("quantity") Integer quantity,
                                                      @Param("category") String category);

    // get product by quantity range
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE quantity >= ?1 " +
            "AND quantity <= ?2", nativeQuery = true)
    List<ProductDto> getProductsByQuantityRange(@Param("minQuantity") Integer minQuantity,
                                                @Param("maxQuantity") Integer maxQuantity);

    // get all products sorted by price
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "ORDER BY price", nativeQuery = true)
    List<ProductDto> getAllProductsSortedByPrice(Double price);

    // get all products sorted by quantity
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "ORDER BY quantity", nativeQuery = true)
    List<ProductDto> getAllProductsSortedByQuantity(Integer quantity);

    // get all products sorted by name
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "ORDER BY name", nativeQuery = true)
    List<ProductDto> getAllProductsSortedByName(String name);

    // get all products sorted by category
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "ORDER BY category", nativeQuery = true)
    List<ProductDto> getAllProductsSortedByCategory(String category);

    // get all products sorted by price range
    @Query(value =
            "SELECT * " +
            "FROM product " +
            "WHERE price >= ?1 " +
            "AND price <= ?2 " +
            "ORDER BY price", nativeQuery = true)
    List<ProductDto> getAllProductsSortedByPriceRange(Double minPrice, Double maxPrice);

    // delete product by name
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM product " +
            "WHERE name = ?1", nativeQuery = true)
    void deleteProductByName(String name);

    // delete product by id
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM product " +
            "WHERE id = ?1", nativeQuery = true)
    void deleteProductById(Long id);

    // delete product by name and category
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM product " +
            "WHERE name = ?1 " +
            "AND category = ?2", nativeQuery = true)
    void deleteProductByNameAndCategory(String name, String category);

    // delete product by category
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM product " +
            "WHERE category = ?1", nativeQuery = true)
    void deleteProductByCategory(String category);

    // delete product by price
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM product " +
            "WHERE price = ?1", nativeQuery = true)
    void deleteProductByPrice(Double price);

    // delete product by quantity
    @Modifying
    @Query(value =
            "DELETE " +
            "FROM product " +
            "WHERE quantity = ?1", nativeQuery = true)
    void deleteProductByQuantity(Integer quantity);

    // update product by id
    @Modifying
    @Query(value =
            "UPDATE product " +
            "SET name = ?2, " +
            "category = ?3, " +
            "price = ?4, " +
            "quantity = ?5 " +
            "WHERE id = ?1", nativeQuery = true)
    void updateProductById(Long id, ProductDto productDto);

    // update product by name
    @Modifying
    @Query(value =
            "UPDATE product " +
            "SET name = ?2, " +
            "category = ?3, " +
            "price = ?4, " +
            "quantity = ?5 " +
            "WHERE name = ?1", nativeQuery = true)
    void updateProductByName(String name, ProductDto productDto);

    // update product by category
    @Modifying
    @Query(value =
            "UPDATE product " +
            "SET name = ?2, " +
            "category = ?3, " +
            "price = ?4, " +
            "quantity = ?5 " +
            "WHERE category = ?1", nativeQuery = true)
    void updateProductByCategory(String category, ProductDto productDto);

}
