package com.example.ordermodule.domain.valueobject;

import com.example.sharedkernel.domain.base.DomainObjectId;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProductId extends DomainObjectId {

    protected ProductId() {
        super(ProductId.randomId(ProductId.class).getId());
    }

    public ProductId(String uuid) {
        super(uuid);
    }

}