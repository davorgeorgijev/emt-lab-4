package com.example.ordermodule.config;

import com.example.ordermodule.domain.models.Customer;
import com.example.ordermodule.domain.repository.CustomerRepository;
import com.example.ordermodule.domain.valueobject.Product;
import com.example.ordermodule.domain.valueobject.ProductId;
import com.example.ordermodule.service.dto.OrderDto;
import com.example.ordermodule.service.dto.OrderItemDto;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final CustomerRepository customerRepository;
    public static List<OrderItemDto> orderItemDtos = new ArrayList<>();
    public static OrderDto orderDto = new OrderDto();

    @PostConstruct
    public void init() {
        Customer customer1 = new Customer("customer1", "customer1");
        Customer customer2 = new Customer("customer2", "customer2");
        if (customerRepository.findAll().isEmpty()) {
            customerRepository.saveAll(Arrays.asList(customer1, customer2));
        }

        OrderItemDto oid1 = new OrderItemDto(new Product(new ProductId("1"),"Coffee", new Money(Currency.MKD, 200)), 10);
        OrderItemDto oid2 = new OrderItemDto(new Product(new ProductId("2"),"Ice cream", new Money(Currency.MKD, 100)), 5);
        orderItemDtos.add(oid1);
        orderItemDtos.add(oid2);

        orderDto.setCurrency(Currency.MKD);
        orderDto.setItems(orderItemDtos);
        orderDto.setCustomerUsername(customer2.getUsername());
    }
}
