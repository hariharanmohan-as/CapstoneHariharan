package com.example.onlineshoppingsystem.cart.service;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.cart.repo.CartRepo;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepo repo;
    @Override
    public Cart addCart(Cart cart) {
        return repo.save(cart);
    }

    @Override
    public Customer findByCustId(int custId) throws CustomerIntNotFound {
        return repo.findByCustId(custId);
    }

    @Override
    public Optional<Cart> findByCustomer(Customer customer) {
        return  repo.findCartByCustomer(customer);
    }

    @Override
    public List<Cart> findCartByCartId(int cartId) {
        return repo.findCartByCartId(cartId);
    }


}
