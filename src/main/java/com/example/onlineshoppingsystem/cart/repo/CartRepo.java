package com.example.onlineshoppingsystem.cart.repo;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>, CartCustomRepo {
    Optional<Cart> findCartByCustomer(Customer customer);
    List<Cart> findCartByCartId(int cartId);

}
