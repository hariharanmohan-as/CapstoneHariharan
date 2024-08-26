package com.example.onlineshoppingsystem.customer.exception;

public class CustomerStringNotFound extends Exception {
    private String cust;
    public CustomerStringNotFound(String cust){
        this.cust = cust;
    }
    public String getMessage(){
        return "Customer " +cust+ " Not Found";
    }

}
