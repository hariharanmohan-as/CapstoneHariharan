package com.example.onlineshoppingsystem.customer.dto;

import com.example.onlineshoppingsystem.cart.dto.Cart;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@ToString@EqualsAndHashCode
@Getter@Setter
public class Customer {
    @Id
    private int custId;
    private String custName;
    private String custEmail;
    private int custNum;
    private String custCity;
    private int custPin;
}
