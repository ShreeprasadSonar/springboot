package ProductControllerTest;

import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.NoBsSpringbootApplication;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Product.commandhandlers.CreateProductCommandHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// This tells it to use entire project to be able to run
@SpringBootTest(classes = NoBsSpringbootApplication.class)
public class CreateProductCommandHandlerTest {
    // Annotation for command handler we actually want to test
    @InjectMocks
    private CreateProductCommandHandler createProductCommandHandler;

    // Using @Mock so that we don't use actual product repository
    @Mock
    private ProductRepository productRepository;

    // To name a test we will follow this format
    // MethodName_StateUnderTest_ExpectedBehavior
    // This will annotate a method that represents a unit test
    @Test
    public void createProductCommandHandler_validProduct_returnsSuccess(){
        // Given
        Product product = new Product();
        product.setId(1);
        product.setPrice(9.99);
        product.setName("Best Chocolate");
        product.setDescription("Silky Dark");
        product.setQuantity(10);

        // When
        ResponseEntity response = createProductCommandHandler.execute(product);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void createProductCommandHandler_invalidPrice_throwsInvalidPriceException(){
        // Given
        Product product = new Product();
        product.setId(1);
        product.setPrice(-9.99);
        product.setName("Best Chocolate");
        product.setDescription("Silky Dark");
        product.setQuantity(10);

        // When / Then 1
        ProductNotValidException exception = assertThrows(ProductNotValidException.class, () -> createProductCommandHandler.execute(product));

        // Then 2
        assertEquals("Product price cannot be negative", exception.getSimpleResponse().getMessage());
    }
}
