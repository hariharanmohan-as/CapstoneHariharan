package com.example.onlineshoppingsystem.product.controller;


import com.example.onlineshoppingsystem.ErrorMessages;
import com.example.onlineshoppingsystem.cart.exception.CartNotAvailableException;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;
import com.example.onlineshoppingsystem.customer.exception.CustomerStringNotFound;
import com.example.onlineshoppingsystem.orders.exception.CustomerOrderNotFoundException;
import com.example.onlineshoppingsystem.orders.exception.OrderNotFoundException;
import com.example.onlineshoppingsystem.orders.exception.OrderPriceNotFoundException;
import com.example.onlineshoppingsystem.product.exception.ProductFloatNotFound;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;
import com.example.onlineshoppingsystem.product.exception.ProductStringNotfound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessages> handleProductNotfounndException(ProductNotFoundException e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.toString());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProductStringNotfound.class)
    public ResponseEntity<ErrorMessages> handleProductNotfounndException(ProductStringNotfound e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProductFloatNotFound.class)
    public ResponseEntity<ErrorMessages> handleProductNotfounndException(ProductFloatNotFound e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomerIntNotFound.class)
    public ResponseEntity<ErrorMessages> handleCustomerNotFoundException(CustomerIntNotFound e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomerStringNotFound.class)
    public ResponseEntity<ErrorMessages> handleCustomerNotFoundException(CustomerStringNotFound e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CartNotAvailableException.class)
    public ResponseEntity<ErrorMessages> handleCartNotFoundException(CartNotAvailableException e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorMessages> handleOrderNotFoundException(OrderNotFoundException e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrderPriceNotFoundException.class)
    public ResponseEntity<ErrorMessages> handleOrderPriceNotFoundException(OrderPriceNotFoundException e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CustomerOrderNotFoundException.class)
    public ResponseEntity<ErrorMessages> handleOrderCustomerNotFoundException(CustomerOrderNotFoundException e){
        ErrorMessages errorMessages = new ErrorMessages(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
}
