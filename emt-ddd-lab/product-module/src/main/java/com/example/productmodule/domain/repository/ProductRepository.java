package com.example.productmodule.domain.repository;

import com.example.productmodule.domain.models.Product;
import com.example.productmodule.domain.models.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
