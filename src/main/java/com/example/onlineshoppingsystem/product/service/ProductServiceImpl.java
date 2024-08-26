package com.example.onlineshoppingsystem.product.service;

import com.example.onlineshoppingsystem.product.dto.Product;
import com.example.onlineshoppingsystem.product.exception.ProductFloatNotFound;
import com.example.onlineshoppingsystem.product.exception.ProductNotFoundException;
import com.example.onlineshoppingsystem.product.exception.ProductStringNotfound;
import com.example.onlineshoppingsystem.product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo repo;
    @Override
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repo.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        repo.deleteById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product findById(int productId) throws ProductNotFoundException {
        Optional<Product> find = repo.findById(productId);
        if(find.isEmpty()){
            throw new ProductNotFoundException();
        }
        return find.get();
    }

    @Override
    public List<Product> findProductByProductCategory(String productCategory) throws ProductStringNotfound {
        List<Product> find = repo.findByProductCategory(productCategory);
        if(find.isEmpty()){
            throw new ProductStringNotfound(productCategory);
        }
        return find;
    }

    @Override
    public List<Product> findProductByProductPrice(float productPrice) throws ProductFloatNotFound {
        List<Product> find = repo.findByProductPrice(productPrice);
        if(find.isEmpty()){
            throw new ProductFloatNotFound(productPrice);
        }
        return find;
    }

    @Override
    public List<Product> findProductByProductRating(int productRating) throws ProductNotFoundException {
        List<Product> find = repo.findByProductRating(productRating);
        if(find.isEmpty()){
            throw new ProductNotFoundException();
        }
        return find;
    }

    @Override
    public List<Product> findProductByProductName(String productName) throws ProductStringNotfound {
        List<Product> find = repo.findByProductName(productName);
        if(find.isEmpty()){
            throw new ProductStringNotfound(productName);
        }
        return find;
    }

    @Override
    public List<Product> findByProductPriceGreaterThan(float productPrice) throws ProductFloatNotFound {
        List<Product> find = repo.findByProductPriceGreaterThan(productPrice);
        if(find.isEmpty()){
            throw new ProductFloatNotFound(productPrice);
        }
        return find;
    }

    @Override
    public List<Product> findByProductPriceLessThan(float productPrice) throws ProductFloatNotFound {
        List<Product> find = repo.findByProductPriceLessThan(productPrice);
        if(find.isEmpty()){
            throw new ProductFloatNotFound(productPrice);
        }
        return find;
    }
}
