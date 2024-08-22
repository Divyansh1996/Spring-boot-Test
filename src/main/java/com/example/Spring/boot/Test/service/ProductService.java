package com.example.Spring.boot.Test.service;

import com.example.Spring.boot.Test.model.Product;
import com.example.Spring.boot.Test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public String addProduct(Product product){
        productRepository.save(product);
        return "Product added";
    }

    public Product getProductByDescription(String description){
        Product product = productRepository.getProductByDescription(description);
        return product;
    }
}
