package easyBot.testTask.service;

import easyBot.testTask.dto.create.LaptopInputDto;
import easyBot.testTask.dto.create.ProductInputDto;
import easyBot.testTask.dto.create.ScreenInputDto;
import easyBot.testTask.dto.update.ProductUpdateDto;
import easyBot.testTask.dto.update.ScreenUpdateDto;
import easyBot.testTask.model.Product;
import easyBot.testTask.utils.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;

    @Test
    void addProduct() {
        ProductInputDto productInputDto = new ScreenInputDto(13.2);
        productInputDto.setCount(1);
        productInputDto.setMaker("maker");
        productInputDto.setPrice(340);
        productInputDto.setSerialNumber("number");
        Product productFromDB = productService.addProduct(productInputDto);
        assertEquals("number", productFromDB.getSerialNumber());
    }

    @Test
    void updateProduct() {
        ProductInputDto productInputDto = new ScreenInputDto(13.2);
        productInputDto.setCount(1);
        productInputDto.setMaker("maker");
        productInputDto.setPrice(340);
        productInputDto.setSerialNumber("number");
        Product product = productService.addProduct(productInputDto);

        ProductUpdateDto productUpdateDto = new ScreenUpdateDto(13.2);
        productUpdateDto.setCount(1);
        productUpdateDto.setMaker("maker");
        productUpdateDto.setPrice(340);
        productUpdateDto.setSerialNumber("numberNew");
        productUpdateDto.setId(product.getId());
        Product productFromDB = productService.updateProduct(productUpdateDto);
        assertEquals("numberNew", productFromDB.getSerialNumber());
    }

    @Test
    void getProductsByType() {
        ProductInputDto productInputDto = new ScreenInputDto(13.2);
        productInputDto.setCount(1);
        productInputDto.setMaker("maker");
        productInputDto.setPrice(340);
        productInputDto.setSerialNumber("number");
        productService.addProduct(productInputDto);

        List<Product> productFromDB = productService.getProductsByType("screen");
        assertEquals("maker", productFromDB.get(0).getMaker());
    }

    @Test
    void getProductById() {
        ProductInputDto productInputDto = new LaptopInputDto(13);
        productInputDto.setCount(4);
        productInputDto.setMaker("Maker");
        productInputDto.setPrice(100);
        productInputDto.setSerialNumber("Number");
        Product productFromDB = productService.addProduct(productInputDto);
        UUID id = productFromDB.getId();
        Product productGetFromDB = productService.getProductById(id);
        assertEquals(id, productGetFromDB.getId());
    }
}