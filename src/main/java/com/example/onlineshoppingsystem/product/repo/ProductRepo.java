package com.example.onlineshoppingsystem.product.repo;

import com.example.onlineshoppingsystem.product.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    public List<Product> findByProductCategory(String productCategory);
    public List<Product> findByProductPrice(float productPrice);
    public List<Product> findByProductRating(int productRating);
    public List<Product> findByProductName(String productName);
    public List<Product> findByProductPriceGreaterThan(float productPrice);
    public List<Product> findByProductPriceLessThan(float productPrice);
}
