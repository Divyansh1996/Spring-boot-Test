package com.example.Spring.boot.Test.repository;

import com.example.Spring.boot.Test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT u FROM Product u WHERE u.description = ?1")
    public Product getProductByDescription(String description);
}
