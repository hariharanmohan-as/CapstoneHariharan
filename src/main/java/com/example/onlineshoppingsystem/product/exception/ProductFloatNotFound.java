package com.example.onlineshoppingsystem.product.exception;

public class ProductFloatNotFound extends Exception{
    private float product;
    public ProductFloatNotFound(float product){
        this.product = product;
    }
    public String getMessage(){
        return "Product" + product + "NotFound";
    }
}
