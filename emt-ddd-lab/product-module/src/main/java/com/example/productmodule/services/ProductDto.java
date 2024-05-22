package com.example.productmodule.services;

import com.example.sharedkernel.domain.financial.Money;
import lombok.Data;

@Data
public class ProductDto {
    private String productName;
    private Money price;
}
