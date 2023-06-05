package easyBot.testTask.controller;

import easyBot.testTask.dto.create.ProductInputDto;
import easyBot.testTask.dto.update.ProductUpdateDto;
import easyBot.testTask.model.Product;
import easyBot.testTask.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public Optional<Product> addProduct(@RequestBody ProductInputDto productInputDto) {
        return productService.addProduct(productInputDto);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody ProductUpdateDto productUpdateDto) {
        return productService.updateProduct(productUpdateDto);
    }

    @GetMapping("/{type}")
    public List<Product> getProductsByType(@PathVariable String type) {
        return productService.getProductsByType(type);
    }

    @GetMapping
    public Product getProductById(@RequestParam UUID id) {
        return productService.getProductById(id);
    }
}
