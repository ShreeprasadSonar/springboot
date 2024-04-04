package ProductControllerTest;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.Exceptions.ProductNotValidException;
import com.example.demo.NoBsSpringbootApplication;
import com.example.demo.Product.Model.Product;
import com.example.demo.Product.Model.ProductDTO;
import com.example.demo.Product.ProductRepository;
import com.example.demo.Product.queryhandlers.GetProductQueryHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = NoBsSpringbootApplication.class)
public class GetProductQueryHandlerTest {
    @InjectMocks
    private GetProductQueryHandler getProductQueryHandler;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void getProductQueryHandler_validId_returnsProductDTO(){
        // Given
        Product product = new Product();
        product.setId(1);
        product.setPrice(-9.99);
        product.setName("Best Chocolate");
        product.setDescription("Silky Dark");
        product.setQuantity(10);

        ProductDTO expectedDTO = new ProductDTO(product);

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        // When
        ResponseEntity<ProductDTO> actualResponse =getProductQueryHandler.execute(product.getId());

        assertEquals(expectedDTO, actualResponse.getBody());
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());

    }

    @Test
    public void getProductQueryHandler_inValidId_throwsProductNotFoundException(){
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        // When / Then 1
        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () -> getProductQueryHandler.execute(1));

        //Then
        assertEquals("Product Not Found", exception.getSimpleResponse().getMessage());
    }

}
