package com.example.onlineshoppingsystem.cart.repo;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;
import com.example.onlineshoppingsystem.product.dto.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CartCustomRepoImpl implements CartCustomRepo {
    @PersistenceContext
    private EntityManager em;
    @Override
    public Customer findByCustId(int custId) throws CustomerIntNotFound {
        Customer customer = em.find(Customer.class, custId);
        if (customer == null){
            throw new CustomerIntNotFound(custId);
        }
        return customer;
    }

}
