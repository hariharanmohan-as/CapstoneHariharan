package com.example.onlineshoppingsystem.cart.exception;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cartLine.dto.CartLine;

import java.util.List;
import java.util.Optional;

public class CartNotAvailableException extends Exception{
    private List<CartLine> cart;
    public CartNotAvailableException(List<CartLine> cart){
        this.cart = cart;
    }
    public String getMessage(){
        return "Cart " +cart+ "is empty";
    }

}
