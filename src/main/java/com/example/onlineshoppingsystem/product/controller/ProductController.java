package com.example.onlineshoppingsystem.product.controller;

import com.example.onlineshoppingsystem.product.dto.Product;
import com.example.onlineshoppingsystem.product.exception.ProductFloatNotFound;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;
import com.example.onlineshoppingsystem.product.exception.ProductStringNotfound;
import com.example.onlineshoppingsystem.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
    @DeleteMapping("/delete/{productId}")
    public void deleteProduct(@PathVariable ("productId") int productId){
        productService.deleteProduct(productId);
    }
    @GetMapping("/id/{productId}")
    public Product returnProduct(@PathVariable ("productId") int productId ) throws ProductNotFoundException {
        return productService.findById(productId);
    }
    @GetMapping("/category/{productCategory}")
    public List<Product> findByProductCategory(@PathVariable ("productCategory") String productCategory) throws ProductStringNotfound {
        return productService.findProductByProductCategory(productCategory);
    }
    @GetMapping("/price/{productPrice}")
    public List<Product> findByProductPrice(@PathVariable ("productPrice") float productPrice) throws ProductFloatNotFound {
        return productService.findProductByProductPrice(productPrice);
    }
    @GetMapping("/rating/{productRating}")
    public List<Product> findByProductRating(@PathVariable ("productRating") int productRating) throws ProductNotFoundException {
        return productService.findProductByProductRating(productRating);
    }
    @GetMapping("/name/{productName}")
    public List<Product> findByProductName(@PathVariable ("productName") String productName) throws ProductStringNotfound {
        return productService.findProductByProductName(productName);
    }
    @GetMapping("/great/{productPrice}")
    public List<Product> findByProductPriceGreaterThan(@PathVariable ("productPrice") float productPrice) throws ProductFloatNotFound {
        return productService.findByProductPriceGreaterThan(productPrice);
    }
    @GetMapping("/less/{productPrice}")
    public List<Product> findByProductPriceLessThan(@PathVariable ("productPrice") float productPrice) throws ProductFloatNotFound {
        return productService.findByProductPriceLessThan(productPrice);
    }
}
