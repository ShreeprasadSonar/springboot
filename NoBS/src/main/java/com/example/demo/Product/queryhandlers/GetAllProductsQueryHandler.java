package com.example.demo.Product.queryhandlers;

import com.example.demo.Product.Model.Product;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Tells Spring boot that this is your business logic
public class GetAllProductsQueryHandler implements Query<Void, List<Product>> {

    @Autowired // Injects an instance of ProductRepository into this class.
    private ProductRepository productRepository;
    @Override
    // Executes the query to retrieve all products from the database.
    public ResponseEntity<List<Product>> execute(Void input) {
        // Returns a ResponseEntity with HTTP status OK and the list of products retrieved from the repository.// Returns a ResponseEntity with HTTP status OK and the list of products retrieved from the repository.
        return ResponseEntity.ok(productRepository.findAll());
    }
}
