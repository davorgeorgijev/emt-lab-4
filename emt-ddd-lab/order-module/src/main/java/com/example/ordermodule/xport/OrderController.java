package com.example.ordermodule.xport;

import com.example.ordermodule.config.DataInitializer;
import com.example.ordermodule.domain.models.Order;
import com.example.ordermodule.domain.models.OrderId;
import com.example.ordermodule.service.OrderService;
import com.example.ordermodule.service.dto.OrderDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/placeOrder")
    public Order placeOrder(){
        return orderService.placeOrder(DataInitializer.orderDto);
    }
}
