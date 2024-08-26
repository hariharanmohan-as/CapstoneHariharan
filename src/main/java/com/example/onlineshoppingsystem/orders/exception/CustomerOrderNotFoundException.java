package com.example.onlineshoppingsystem.orders.exception;

import com.example.onlineshoppingsystem.customer.dto.Customer;

public class CustomerOrderNotFoundException extends Exception{
    private Customer customer;
    public CustomerOrderNotFoundException(Customer customer) {
        this.customer = customer;
    }
    public String getMessage() {
        return "Order with " +customer+ " found";
    }
}
