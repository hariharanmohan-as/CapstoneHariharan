package com.example.onlineshoppingsystem.orders.controller;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.orders.dto.Orders;
import com.example.onlineshoppingsystem.orders.exception.CustomerOrderNotFoundException;
import com.example.onlineshoppingsystem.orders.exception.OrderNotFoundException;
import com.example.onlineshoppingsystem.orders.exception.OrderPriceNotFoundException;
import com.example.onlineshoppingsystem.orders.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/shop/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/view")
    public List<Orders> getOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/date/{dateOfOrder}")
    public List<Orders> getOrdersByDate(@PathVariable ("dateOfOrder") Date dateOfOrder) throws OrderNotFoundException {
        return orderService.findByDateOfOrder(dateOfOrder);
    }
    @GetMapping("/price/{totalPrice}")
    public List<Orders> getOrdersByTotalPrice(@PathVariable ("totalPrice") double totalPrice) throws OrderPriceNotFoundException {
        return orderService.findByTotalPrice(totalPrice);
    }
    @GetMapping("/cust/{custId}")
    public List<Orders> getOrdersByCustId(@PathVariable ("custId")Customer customer) throws CustomerOrderNotFoundException {
        return orderService.findByCustomer(customer);
    }
    @Transactional
    @DeleteMapping("/delete/{custId}")
    public List<Orders> deleteOrder(@PathVariable ("custId") Customer cust) {
        return orderService.deleteByCustomer(cust);
    }
}
