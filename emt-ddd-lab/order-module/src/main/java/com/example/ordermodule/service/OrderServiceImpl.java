package com.example.ordermodule.service;


import com.example.ordermodule.domain.models.Order;
import com.example.ordermodule.domain.models.OrderId;
import com.example.ordermodule.domain.models.OrderItemId;
import com.example.ordermodule.domain.repository.OrderRepository;
import com.example.ordermodule.service.dto.OrderDto;
import com.example.ordermodule.service.dto.OrderItemDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    @Override
    public Order placeOrder(OrderDto orderDto) {
        Objects.requireNonNull(orderDto, "order must not be null.");
        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderDto));
        return newOrder;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemDto orderItemDto) {
        Order order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        order.addItem(orderItemDto.getProduct(), orderItemDto.getQuantity());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteItem(OrderId orderId, OrderItemId orderItemId) {
        Order order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        order.removeItem(orderItemId);
        orderRepository.saveAndFlush(order);
    }



    private Order toDomainObject(OrderDto orderDto) {
        var customer = customerService.findByUsername(orderDto.getCustomerUsername());
        var order = new Order(Instant.now(), orderDto.getCurrency(), customer);
        orderDto.getItems().forEach(item -> order.addItem(item.getProduct(), item.getQuantity()));
        customer.increaseDiscountPoints();
        return order;
    }
}
