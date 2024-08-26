package com.example.onlineshoppingsystem.cart.dto;

import com.example.onlineshoppingsystem.cartLine.dto.CartLine;
import com.example.onlineshoppingsystem.customer.dto.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@ToString@EqualsAndHashCode
public class Cart {
    @Id
    @GeneratedValue
    private int cartId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<CartLine> cartLineList = new ArrayList<>();


}
