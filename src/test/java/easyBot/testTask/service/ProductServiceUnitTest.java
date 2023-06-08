package easyBot.testTask.service;

import easyBot.testTask.dto.create.LaptopInputDto;
import easyBot.testTask.dto.create.ProductInputDto;
import easyBot.testTask.dto.create.ScreenInputDto;
import easyBot.testTask.dto.update.ProductUpdateDto;
import easyBot.testTask.dto.update.ScreenUpdateDto;
import easyBot.testTask.model.Product;
import easyBot.testTask.repository.ProductRepository;
import easyBot.testTask.utils.ProductMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ProductServiceUnitTest {
    @InjectMocks
    ProductServiceImpl productService;
    @Mock
    ProductRepository productRepository;
    @Mock
    ProductMapper productMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addProduct() {
        ProductInputDto productInputDto = Mockito.mock(ProductInputDto.class);
        Product product = Mockito.mock(Product.class);

        when(productMapper.toProduct(any(ProductInputDto.class))).thenReturn(product);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product newProduct = productService.addProduct(productInputDto);

        verify(productMapper, times(1)).toProduct(productInputDto);
        assertNull(newProduct.getSerialNumber());
    }

    @Test
    void updateProduct() {
        ProductUpdateDto productUpdateDto = Mockito.mock(ProductUpdateDto.class);
        Product product = Mockito.mock(Product.class);
        Optional<Product> productOptional = Optional.of(product);

        when(productMapper.toProduct(any(ProductUpdateDto.class))).thenReturn(product);
        //todo
        when(productRepository.findById(any(UUID.class))).thenReturn(productOptional);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product newProduct = productService.updateProduct(productUpdateDto);

        verify(productMapper, times(1)).toProduct(productUpdateDto);
        verify(productRepository, times(1)).save(product);

        assertNull(newProduct.getSerialNumber());
    }

    @Test
    void getProductsByType() {

    }

    @Test
    void getProductById() {

    }
}