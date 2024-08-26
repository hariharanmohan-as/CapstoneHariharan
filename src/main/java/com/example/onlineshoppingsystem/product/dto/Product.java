package com.example.onlineshoppingsystem.product.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
@ToString@EqualsAndHashCode
public class Product {
    @Id
    private int productId;
    private String productName;
    private String productCategory;
    private float productPrice;
    private int productRating;
    private int productStock;
}
