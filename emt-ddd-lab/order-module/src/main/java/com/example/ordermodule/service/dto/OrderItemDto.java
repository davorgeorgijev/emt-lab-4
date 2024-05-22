package com.example.ordermodule.service.dto;

import com.example.ordermodule.domain.valueobject.Product;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemDto {
    @NotNull
    private Product product;

    @Min(1)
    private int quantity = 1;

    public OrderItemDto(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
