package com.example.onlineshoppingsystem.orders.exception;

import java.sql.Date;

public class OrderNotFoundException extends Exception{
    private Date date;
    public OrderNotFoundException(Date date) {
        this.date = date;
    }
    public String getMessage() {
        return "Date " +date+ " found";
    }
}
