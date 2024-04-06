package com.example.demo.Product.commandhandlers;

import com.example.demo.Command;
import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommandHandler implements Command<Product, ResponseEntity> {
    @Autowired private ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(CreateProductCommandHandler.class);
    @Override
    public ResponseEntity execute(Product product) {
        logger.info("Executing" +  getClass() + " with " + product.toString());
        validateProduct(product);
        productRepository.save(product);
        return ResponseEntity.ok().build();
        // .build() is used to construct and finalize the ResponseEntity with an HTTP status code indicating success (200 OK) without providing a body.
    }
    private void validateProduct(Product product){
        // Logic needs to be added to validate the fields
        // Name - Non-Null, No whitespace, Not Empty
        if(StringUtils.isBlank(product.getName())){
            logger.error("Product not valid exception was thrown (invalid name) " + product.toString());
            // Throw Exception
            throw new ProductNotValidException("Product name cannot be empty");
        }
        // Description
        if(StringUtils.isBlank(product.getDescription())){
            logger.error("Product not valid exception was thrown (invalid description)" + product.toString());
            // Throw Exception
            throw new ProductNotValidException("Product description name cannot be empty");
        }
        // Price
        if(product.getPrice() <= 0.0){
            logger.error("Product not valid exception was thrown (invalid price)" + product.toString());
            // Throw Exception
            throw new ProductNotValidException("Product price cannot be negative");
        }
        // Quantity
        if(product.getQuantity() <= 0){
            logger.error("Product not valid exception was thrown (invalid quantity)" + product.toString());
            // Throw Exception
            throw new ProductNotValidException("Product quantity cannot be negative");
        }
    }
}
