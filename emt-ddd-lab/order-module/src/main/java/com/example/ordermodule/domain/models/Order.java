package com.example.ordermodule.domain.models;

import com.example.ordermodule.domain.valueobject.Product;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import org.apache.catalina.User;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;
    @ManyToOne
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();

    protected Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant now, Currency currency, Customer customer) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency = currency;
        this.customer = customer;
    }

    public Money total() {
        var money = orderItemList.stream()
                .map(OrderItem::subtotal)
                .reduce(new Money(currency, 0), Money::add);
        return money.priceWithDiscount(this.customer.getDiscountPoints());
    }

    public OrderItem addItem(@NonNull Product product, int qty) {
        Objects.requireNonNull(product, "product must not be null");
        var item = new OrderItem(product.getId(), product.getPrice(), qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId, "Order Item must not be null");
        orderItemList.removeIf(v -> v.getId().equals(orderItemId));
    }
}

