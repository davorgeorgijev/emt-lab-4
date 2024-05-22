package com.example.ordermodule.service;

import com.example.ordermodule.domain.models.Order;
import com.example.ordermodule.domain.models.OrderId;
import com.example.ordermodule.domain.models.OrderItemId;
import com.example.ordermodule.service.dto.OrderDto;
import com.example.ordermodule.service.dto.OrderItemDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(OrderDto orderDto);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemDto orderItemDto);

    void deleteItem(OrderId orderId, OrderItemId orderItemId);

}
