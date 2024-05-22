package com.example.productmodule.domain.models;

import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "product")
@Getter
public class Product extends AbstractEntity<ProductId> {
    private String productName;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;

    protected Product() {
        super(ProductId.randomId(ProductId.class));
    }

    public static Product build(String productName, Money price) {
        Product p = new Product();
        p.price = price;
        p.productName = productName;
        return p;
    }
}
