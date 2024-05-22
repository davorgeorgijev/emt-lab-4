package com.example.ordermodule.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;

@Entity
@Data
public class Customer {
    @Id
    private String username;
    private String password;
    @Max(50)
    private int discountPoints;

    public Customer() {
        this.discountPoints = 0;
        this.username = "";
        this.password = "";
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.discountPoints = 0;
    }

    public void increaseDiscountPoints() {
        this.discountPoints += 5;
    }
}
