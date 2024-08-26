package com.example.onlineshoppingsystem.product.service;


import com.example.onlineshoppingsystem.product.dto.Product;
import com.example.onlineshoppingsystem.product.exception.ProductFloatNotFound;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;
import com.example.onlineshoppingsystem.product.exception.ProductStringNotfound;

import java.util.List;

public interface ProductService {
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(int productId);
    public List<Product> getAllProducts();
    public Product findById(int productId) throws ProductNotFoundException;
    public List<Product> findProductByProductCategory(String productCategory) throws ProductStringNotfound;
    public List<Product> findProductByProductPrice(float productPrice) throws ProductFloatNotFound;
    public List<Product> findProductByProductRating(int productRating) throws ProductNotFoundException;
    public List<Product> findProductByProductName(String productName) throws ProductStringNotfound;
    public List<Product> findByProductPriceGreaterThan(float productPrice) throws ProductFloatNotFound;
    public List<Product> findByProductPriceLessThan(float productPrice) throws ProductFloatNotFound;
}
