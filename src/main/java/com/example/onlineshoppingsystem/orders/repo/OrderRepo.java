package com.example.onlineshoppingsystem.orders.repo;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.orders.dto.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
    public List<Orders> findByDateOfOrder(Date date);
    public List<Orders> findByTotalPrice(double totalPrice);
    public List<Orders> findByCustomer(Customer customer);
    public List<Orders> deleteByCustomer(Customer customer);
}
