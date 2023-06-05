package easyBot.testTask.service;

import easyBot.testTask.dto.create.ProductInputDto;
import easyBot.testTask.dto.update.ProductUpdateDto;
import easyBot.testTask.exception.ProductException;
import easyBot.testTask.utils.ProductMapper;
import easyBot.testTask.repository.ProductRepository;
import easyBot.testTask.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    /**
     * Добавление товара любого вида в базу.
     *
     * @param productInputDto
     * @return
     */
    @Override
    public Optional<Product> addProduct(ProductInputDto productInputDto) {
        try {
            Product product = productMapper.toProduct(productInputDto);
            Product productFromBD = productRepository.save(product);
            log.info("addProduct: {}", productInputDto);
            return productRepository.findById(productFromBD.getId());
        } catch (Exception e) {
            log.error("addProduct: throw new ProductException");
            throw new ProductException("Ошибка добавления товара: " + productInputDto.toString());
        }
    }

    /**
     * Обновление товара любого вида, если он есть в базе. В ином случае - ProductException.
     *
     * @param productUpdateDto
     * @return
     */
    @Override
    public Product updateProduct(ProductUpdateDto productUpdateDto) {
        try {
            Product product = productMapper.toProduct(productUpdateDto);
            Optional<Product> productFromBD = productRepository.findById(productUpdateDto.getId());
            if (productFromBD.isEmpty()) {
                throw new ProductException();
            }
            log.info("updateProduct: {}", productUpdateDto);
            return productRepository.save(product);
        } catch (ProductException e) {
            log.error("updateProduct: throw new ProductException");
            throw new ProductException("Товара с id = " + productUpdateDto.getId() + " нет.");
        } catch (Exception e) {
            log.error("updateProduct: throw new ProductException");
            throw new ProductException("Ошибка обновления товара: " + productUpdateDto.toString());
        }
    }

    /**
     * Поиск списка товаров в зависимости от типа
     *
     * @param type
     * @return
     */
    @Override
    public List<Product> getProductsByType(String type) {
        try {
            log.info("getProductsByType: {}", type);
            return productRepository.findAll()
                    .stream()
                    .filter(p -> p.getClass().getSimpleName().toLowerCase().equals(type))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("getProductsByType: throw new ProductException");
            throw new ProductException("Ошибка получения товаров: " + type);
        }
    }

    /**
     * Поиск товара любого типа по id
     *
     * @param uuid
     * @return
     */
    @Override
    public Product getProductById(UUID uuid) {
        try {
            Optional<Product> productFromBD = productRepository.findById(uuid);
            if (productFromBD.isEmpty()) {
                throw new ProductException();
            }
            log.info("getProductById: {}", productFromBD);
            return productFromBD.get();
        } catch (ProductException e) {
            log.error("getProductById: throw new ProductException");
            throw new ProductException("Товара с id = " + uuid + " нет.");
        } catch (Exception e) {
            log.error("getProductById: throw new ProductException");
            throw new ProductException("Ошибка получения товара: " + uuid);
        }
    }
}
