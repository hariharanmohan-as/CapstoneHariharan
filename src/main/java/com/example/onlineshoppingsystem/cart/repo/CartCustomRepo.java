package com.example.onlineshoppingsystem.cart.repo;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;


public interface CartCustomRepo {

    Customer findByCustId(int custId) throws CustomerIntNotFound;


}
