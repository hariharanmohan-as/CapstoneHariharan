package com.example.onlineshoppingsystem.product.exception;

public class ProductStringNotfound extends Exception{
    private String product;
    public ProductStringNotfound(String product){
        this.product = product;
    }
    public String getMessage(){
        return "Product " + product + " Not found";
    }
}
