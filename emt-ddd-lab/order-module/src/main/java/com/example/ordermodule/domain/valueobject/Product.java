package com.example.ordermodule.domain.valueobject;


import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product implements ValueObject {

    private final ProductId id;
    private final String name;
    private final Money price;

    private Product() {
        this.id=ProductId.randomId(ProductId.class);
        this.name= "";
        this.price = Money.valueOf(Currency.MKD,0);
    }

}
