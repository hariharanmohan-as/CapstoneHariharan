package com.example.onlineshoppingsystem.orders.service;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.orders.dto.Orders;
import com.example.onlineshoppingsystem.orders.exception.CustomerOrderNotFoundException;
import com.example.onlineshoppingsystem.orders.exception.OrderNotFoundException;
import com.example.onlineshoppingsystem.orders.exception.OrderPriceNotFoundException;
import com.example.onlineshoppingsystem.orders.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo repo;

    @Override
    public Orders save(Orders orders) {
        return repo.save(orders);
    }

    @Override
    public List<Orders> getAllOrders() {
        return repo.findAll();
    }

    @Override
    public List<Orders> findByDateOfOrder(Date date) throws OrderNotFoundException {
        List<Orders> orders = repo.findByDateOfOrder(date);
        if (orders.isEmpty()) {
            throw new OrderNotFoundException(date);
        }
        return orders;
    }

    @Override
    public List<Orders> findByTotalPrice(double totalPrice) throws OrderPriceNotFoundException {
        List<Orders> orders = repo.findByTotalPrice(totalPrice);
        if (orders.isEmpty()) {
            throw new OrderPriceNotFoundException(totalPrice);
        }
        return orders;
    }

    @Override
    public List<Orders> findByCustomer(Customer customer) throws CustomerOrderNotFoundException {
        List<Orders> orders = repo.findByCustomer(customer);
        if (orders.isEmpty()) {
            throw new CustomerOrderNotFoundException(customer);
        }
        return orders;
    }

    @Override
    public List<Orders> deleteByCustomer(Customer customer) {
        return repo.deleteByCustomer(customer);
    }
}
