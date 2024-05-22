package com.example.ordermodule.domain.repository;

import com.example.ordermodule.domain.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer findByUsername(String username);
}
