package com.example.ordermodule.domain.repository;

import com.example.ordermodule.domain.models.Order;
import com.example.ordermodule.domain.models.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}