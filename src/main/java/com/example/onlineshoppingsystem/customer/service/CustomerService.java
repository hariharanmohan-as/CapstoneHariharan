package com.example.onlineshoppingsystem.customer.service;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;
import com.example.onlineshoppingsystem.customer.exception.CustomerStringNotFound;

import java.util.List;

public interface CustomerService {
    public Customer createCust(Customer customer);
    public Customer updateCust(Customer customer);
    public void deleteById(int custId);
    public List<Customer> getAll();
    public List<Customer> findByCustName(String custName) throws CustomerStringNotFound;
    public Customer findById(int custId) throws CustomerIntNotFound;
    public List<Customer> findByCustEmail(String custEmail) throws CustomerStringNotFound;
    public List<Customer> findByCustNum(int custNum) throws CustomerIntNotFound;
    public List<Customer> findByCustCity(String custCity) throws CustomerStringNotFound;
    public List<Customer> findByCustPin(int custPin) throws CustomerIntNotFound;

}
