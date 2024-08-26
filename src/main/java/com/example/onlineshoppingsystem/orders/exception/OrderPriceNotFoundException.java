package com.example.onlineshoppingsystem.orders.exception;

import java.sql.Date;

public class OrderPriceNotFoundException extends Exception{
    private Double price;
    public OrderPriceNotFoundException(Double price) {
        this.price = price;
    }
    public String getMessage() {
        return "Order with " +price+ " found";
    }
}
