package com.example.ordermodule.service;


import com.example.ordermodule.domain.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer findByUsername(String username);
}
