package com.example.demo.Product.queryhandlers;

import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDTO;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Tells Spring boot that this is your business logic
public class GetAllProductsQueryHandler implements Query<Void, List<ProductDTO>> {
    @Autowired // Injects an instance of ProductRepository into this class.
    private ProductRepository productRepository;
    @Override
    // Executes the query to retrieve all products from the database.
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        /*
        In this Java code snippet, a list of ProductDTO objects is being created from the
        entities retrieved by the productRepository. It first retrieves all products from
        the repository, then converts each product entity into a ProductDTO object using the
        map() function with ProductDTO::new as the mapping function, which likely invokes a
        constructor of ProductDTO. Finally, the result is collected into a list using the
        toList() terminal operation.
         */
        List<ProductDTO> productDTOs = productRepository.getAllProductDTOs();
        // Returns a ResponseEntity with HTTP status OK and the list of products retrieved from the repository.// Returns a ResponseEntity with HTTP status OK and the list of products retrieved from the repository.
        return ResponseEntity.ok(productDTOs);
    }
}
