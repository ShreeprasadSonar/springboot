package com.example.demo.Product.queryhandlers;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDTO;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Tells Spring boot that this is your business logic
public class GetProductQueryHandler implements Query<Integer, ProductDTO> {
    @Autowired private ProductRepository productRepository;

    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDTO> execute(Integer id) {
        // Optionals: Lets go to repository lets try to find by id if found return the product else throw a null pointer exception
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            // throw an exception
            // throw new RuntimeException("Product not found");
            throw new ProductNotFoundException();
        }
        return ResponseEntity.ok(new ProductDTO(product.get()));
    }
}
