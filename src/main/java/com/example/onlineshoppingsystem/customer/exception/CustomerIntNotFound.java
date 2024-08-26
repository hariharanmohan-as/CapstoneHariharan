package com.example.onlineshoppingsystem.customer.exception;

public class CustomerIntNotFound extends Exception {
    private int custId;
    public CustomerIntNotFound(int custId){
        this.custId = custId;
    }
    public String getMessage(){
        return "Customer " +custId+ " Not Found";
    }
}
