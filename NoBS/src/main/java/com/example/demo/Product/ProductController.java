package com.example.demo.Product;
import com.example.demo.Product.Model.Product;
import com.example.demo.queryhandlers.GetAllProductsQueryHandler;
import com.example.demo.queryhandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    // Create, Read, Update, Delete
    // Post, Get, Put, Delete

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GetAllProductsQueryHandler getAllProductsQueryHandler;

    @Autowired
    private GetProductQueryHandler getProductQueryHandler;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return getAllProductsQueryHandler.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        return getProductQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.ok().build();
        // .build() is used to construct and finalize the ResponseEntity with an HTTP status code indicating success (200 OK) without providing a body.
    }
    // The @RequestBody annotation binds the HTTP request body to the parameter product in the method createProduct().

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
