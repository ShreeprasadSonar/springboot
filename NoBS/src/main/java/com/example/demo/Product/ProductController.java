package com.example.demo.Product;
import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDTO;
import com.example.demo.Product.Model.UpdateProductCommand;
import com.example.demo.Product.commandhandlers.CreateProductCommandHandler;
import com.example.demo.Product.commandhandlers.DeleteProductCommandHandler;
import com.example.demo.Product.commandhandlers.UpdateProductCommandHandler;
import com.example.demo.Product.queryhandlers.GetAllProductsQueryHandler;
import com.example.demo.Product.queryhandlers.GetProductQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    // Create, Read, Update, Delete
    // Post, Get, Put, Delete

    // Dependency Injection
    // Here we are doing Field Injection
    // Field injection in dependency injection involves injecting dependencies directly into
    // the fields of a class, typically through reflection, rather than using constructor or
    // setter injection.
    @Autowired private ProductRepository productRepository;
    @Autowired private GetAllProductsQueryHandler getAllProductsQueryHandler;
    @Autowired private GetProductQueryHandler getProductQueryHandler;
    @Autowired private CreateProductCommandHandler createProductCommandHandler;
    @Autowired private UpdateProductCommandHandler updateProductCommandHandler;
    @Autowired private DeleteProductCommandHandler deleteProductCommandHandler;


    // Constructor Injection
    /*
    private final ProductRepository productRepository;
    private final GetAllProductsQueryHandler getAllProductsQueryHandler;
    private final GetProductQueryHandler getProductQueryHandLer;
    private final CreateProductCommandHandler createProductCommandHandler;
    private final UpdateProductCommandHandler updateProductCommandHandler;
    private final DeleteProductCommandHandler deleteProductCommandHandler;

    @Autowired
    public ProductController(ProductRepository productRepository, GetAllProductsQueryHandler getAllProductsQueryHandler, GetProductQueryHandler getProductQueryHandLer, CreateProductCommandHandler createProductCommandHandler, UpdateProductCommandHandler updateProductCommandHandler, DeleteProductCommandHandler deleteProductCommandHandler) {
        this.productRepository = productRepository;
        this.getAllProductsQueryHandler = getAllProductsQueryHandler;
        this.getProductQueryHandLer = getProductQueryHandLer;
        this.createProductCommandHandler = createProductCommandHandler;
        this.updateProductCommandHandler = updateProductCommandHandler;
        this.deleteProductCommandHandler = deleteProductCommandHandler;
    }
     */

    // Update Product to ProductDTO for GetMappings
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(){
        return getAllProductsQueryHandler.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id){
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
