package com.example.productmodule.services;


import com.example.productmodule.domain.models.Product;
import com.example.productmodule.domain.models.ProductId;

import java.util.List;

public interface ProductService {
    Product findById(ProductId id);
    Product createProduct(ProductDto dto);
    List<Product> getAll();
}
