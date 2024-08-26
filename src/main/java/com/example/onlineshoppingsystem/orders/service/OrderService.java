package com.example.onlineshoppingsystem.orders.service;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.orders.dto.Orders;
import com.example.onlineshoppingsystem.orders.exception.CustomerOrderNotFoundException;
import com.example.onlineshoppingsystem.orders.exception.OrderNotFoundException;
import com.example.onlineshoppingsystem.orders.exception.OrderPriceNotFoundException;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    public Orders save(Orders orders);
    public List<Orders> getAllOrders();
    public List<Orders> findByDateOfOrder(Date date) throws OrderNotFoundException;
    public List<Orders> findByTotalPrice(double totalPrice) throws OrderPriceNotFoundException;
    public List<Orders> findByCustomer(Customer customer) throws CustomerOrderNotFoundException;
    public List<Orders> deleteByCustomer(Customer customer);
}
