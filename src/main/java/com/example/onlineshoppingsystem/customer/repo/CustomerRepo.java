package com.example.onlineshoppingsystem.customer.repo;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    public List<Customer> findByCustName(String custName);
    public List<Customer> findByCustEmail(String custEmail);
    public List<Customer> findByCustNum(int custNum);
    public List<Customer> findByCustCity(String custCity);
    public List<Customer> findByCustPin(int custPin);

}
