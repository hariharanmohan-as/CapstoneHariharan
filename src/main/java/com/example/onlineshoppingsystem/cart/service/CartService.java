package com.example.onlineshoppingsystem.cart.service;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;

import java.util.List;
import java.util.Optional;

public interface CartService {
    public Cart addCart(Cart cart);
    public Customer findByCustId(int custId) throws CustomerIntNotFound;
    public Optional<Cart> findByCustomer(Customer customer);
    List<Cart> findCartByCartId(int cartId);
}
