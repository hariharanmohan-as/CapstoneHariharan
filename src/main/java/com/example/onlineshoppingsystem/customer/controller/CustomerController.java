package com.example.onlineshoppingsystem.customer.controller;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;
import com.example.onlineshoppingsystem.customer.exception.CustomerStringNotFound;
import com.example.onlineshoppingsystem.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @PostMapping("/add")
    public Customer createCust(@RequestBody Customer customer){
        return service.createCust(customer);
    }
    @PutMapping("/update")
    public Customer updateCust(@RequestBody Customer customer){
        return service.updateCust(customer);
    }
    @DeleteMapping("/delete/{custId}")
    public void deleteById(@PathVariable ("custId") int custId){
        service.deleteById(custId);
    }
    @GetMapping
    public List<Customer> getAll(){
        return service.getAll();
    }
    @GetMapping("/custName/{custName}")
    public List<Customer> getCustByName(@PathVariable("custName") String custName) throws CustomerStringNotFound {
        return service.findByCustName(custName);
    }
    @GetMapping("/custId/{custId}")
    public Customer getCustById(@PathVariable("custId") int custId) throws CustomerIntNotFound {
        return service.findById(custId);
    }
    @GetMapping("/custEmail/{custEmail}")
    public List<Customer> getCustByEmail(@PathVariable("custEmail") String custEmail) throws CustomerStringNotFound {
        return service.findByCustEmail(custEmail);
    }
    @GetMapping("/custNum/{custNum}")
    public List<Customer> getCustByNum(@PathVariable("custNum") int custNum) throws CustomerIntNotFound {
        return service.findByCustNum(custNum);
    }
    @GetMapping("/custCity/{custCity}")
    public List<Customer> getCustByCity(@PathVariable("custCity") String custCity) throws CustomerStringNotFound {
        return service.findByCustCity(custCity);
    }
    @GetMapping("/custPin/{custPin}")
    public List<Customer> getCustByPin(@PathVariable("custPin") int custPin) throws CustomerIntNotFound {
        return service.findByCustPin(custPin);
    }
}
