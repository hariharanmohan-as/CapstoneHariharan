package com.example.onlineshoppingsystem.orderLine.dto;

import com.example.onlineshoppingsystem.orders.dto.Orders;
import com.example.onlineshoppingsystem.product.dto.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter
@ToString@EqualsAndHashCode
public class OrderLine {
    @Id
    @GeneratedValue
    private int orderLineId;
    private int quantity;
    private float unitPrice;
    private float itemTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderID")
    private Orders orders;

    @ManyToOne(fetch = FetchType.EAGER )
    private Product product;
}
