package com.example.onlineshoppingsystem.customer.service;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.customer.exception.CustomerIntNotFound;
import com.example.onlineshoppingsystem.customer.exception.CustomerStringNotFound;
import com.example.onlineshoppingsystem.customer.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo repo;

    @Override
    public Customer createCust(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Customer updateCust(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public void deleteById(int custId) {
        repo.deleteById(custId);
    }

    @Override
    public List<Customer> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Customer> findByCustName(String custName) throws CustomerStringNotFound {
        List<Customer> find = repo.findByCustName(custName);
        if (find.isEmpty()){
            throw new CustomerStringNotFound(custName);
        }
        return find;
    }

    @Override
    public Customer findById(int custId) throws CustomerIntNotFound {
        Optional<Customer> find = repo.findById(custId);
        if (find.isEmpty()){
            throw new CustomerIntNotFound(custId);
        }
        return find.get();
    }

    @Override
    public List<Customer> findByCustEmail(String custEmail) throws CustomerStringNotFound {
        List<Customer> find = repo.findByCustEmail(custEmail);
        if (find.isEmpty()){
            throw new CustomerStringNotFound(custEmail);
        }
        return find;
    }

    @Override
    public List<Customer> findByCustNum(int custNum) throws CustomerIntNotFound {
        List<Customer> find = repo.findByCustNum(custNum);
        if (find.isEmpty()){
            throw new CustomerIntNotFound(custNum);
        }
        return find;
    }

    @Override
    public List<Customer> findByCustCity(String custCity) throws CustomerStringNotFound {
        List<Customer> find = repo.findByCustCity(custCity);
        if (find.isEmpty()){
            throw new CustomerStringNotFound(custCity);
        }
        return find;
    }

    @Override
    public List<Customer> findByCustPin(int custPin) throws CustomerIntNotFound {
        List<Customer> find = repo.findByCustNum(custPin);
        if (find.isEmpty()){
            throw new CustomerIntNotFound(custPin);
        }
        return find;
    }
}
