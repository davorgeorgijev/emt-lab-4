package com.example.ordermodule.service.dto;

import com.example.sharedkernel.domain.financial.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Currency currency;
    private List<OrderItemDto> items = new ArrayList<>();
    private String customerUsername;
}