package easyBot.testTask.service;

import easyBot.testTask.dto.create.ProductInputDto;
import easyBot.testTask.dto.update.ProductUpdateDto;
import easyBot.testTask.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public
interface ProductService {
    Optional<Product> addProduct(ProductInputDto productInputDto);

    Product updateProduct(ProductUpdateDto productUpdateDto);

    List<Product> getProductsByType(String type);

    Product getProductById(UUID uuid);
}
