package com.example.onlineshoppingsystem.product.exception;

public class ProductNotFoundException extends Exception{
    private int productId;

    public ProductNotFoundException(int productId) {
        this.productId = productId;
    }
    public ProductNotFoundException(){

    }
//    public ProductNotFoundException(String productName) {
//        this.productName = productName;
//    }
//    public ProductNotFoundException(String productCategory){
//        this.productCategory = productCategory;
//    }


    public String toString(){
        return "Product with id " + productId +" not found";
    }
}
