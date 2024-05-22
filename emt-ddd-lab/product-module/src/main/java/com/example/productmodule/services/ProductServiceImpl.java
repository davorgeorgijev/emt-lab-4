package com.example.productmodule.services;

import com.example.productmodule.domain.models.Product;
import com.example.productmodule.domain.models.ProductId;
import com.example.productmodule.domain.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product findById(ProductId id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Product createProduct(ProductDto dto) {
        Product product = Product.build(dto.getProductName(),dto.getPrice());
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
