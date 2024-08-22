package com.example.Spring.boot.Test.controller;

import com.example.Spring.boot.Test.model.Product;
import com.example.Spring.boot.Test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/v1/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }

    @GetMapping("/api/v1/product/{description}")
    public ResponseEntity<Product> getProductByDescription(@PathVariable String description) {
        Product product = productService.getProductByDescription(description);
        return ResponseEntity.ok(product);
    }
}
