package com.example.demo.Product;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.UpdateProductCommand;
import com.example.demo.Product.commandhandlers.CreateProductCommandHandler;
import com.example.demo.Product.commandhandlers.DeleteProductCommandHandler;
import com.example.demo.Product.commandhandlers.UpdateProductCommandHandler;
import com.example.demo.Product.queryhandlers.GetAllProductsQueryHandler;
import com.example.demo.Product.queryhandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    // Create, Read, Update, Delete
    // Post, Get, Put, Delete

    @Autowired private ProductRepository productRepository;

    @Autowired private GetAllProductsQueryHandler getAllProductsQueryHandler;

    @Autowired private GetProductQueryHandler getProductQueryHandler;

    @Autowired private CreateProductCommandHandler createProductCommandHandler;

    @Autowired private UpdateProductCommandHandler updateProductCommandHandler;

    @Autowired private DeleteProductCommandHandler deleteProductCommandHandler;

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
        return createProductCommandHandler.execute(product);
    }
    // The @RequestBody annotation binds the HTTP request body to the parameter product in the method createProduct().

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
        UpdateProductCommand command = new UpdateProductCommand(id, product);
        return updateProductCommandHandler.execute(command);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        return deleteProductCommandHandler.execute(id);
    }
}
