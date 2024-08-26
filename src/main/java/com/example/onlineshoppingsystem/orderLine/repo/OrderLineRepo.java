package com.example.onlineshoppingsystem.orderLine.repo;

import com.example.onlineshoppingsystem.orderLine.dto.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepo extends JpaRepository<OrderLine, Integer> {
}
