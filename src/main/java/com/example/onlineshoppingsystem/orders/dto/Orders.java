package com.example.onlineshoppingsystem.orders.dto;

import com.example.onlineshoppingsystem.customer.dto.Customer;
import com.example.onlineshoppingsystem.orderLine.dto.OrderLine;
import com.example.onlineshoppingsystem.product.dto.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@ToString@EqualsAndHashCode
public class Orders {
    @Id
    @GeneratedValue
    private int orderId;
    private Date dateOfOrder;
    private double totalPrice;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderLine> orderLineList;


}
