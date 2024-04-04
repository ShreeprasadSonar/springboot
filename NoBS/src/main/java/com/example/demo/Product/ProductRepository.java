package com.example.demo.Product;

import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // : Tells spring data JPA that maxPrice is a variable name, also we can't use * so using p.
    @Query("SELECT p FROM Product p where p.price < :maxPrice")
    List<Product> findProductsWithPriceLessThan(@Param("maxPrice") double maxPrice);

    @Query("SELECT new com.example.demo.Product.Model.ProductDTO(p.name, p.description, p.price) FROM Product p")
    List<ProductDTO> getAllProductDTOs();

    // Using Spring Data JPA here
    List<Product> findByDescriptionContaining(String keyword);

    // Same using Query
    @Query("SELECT p FROM Product p WHERE p.description LIKE %:description%")
    List<Product> customQueryMethod(@Param(value="description") String description);
}
