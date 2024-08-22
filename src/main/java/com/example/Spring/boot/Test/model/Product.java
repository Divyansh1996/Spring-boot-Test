package com.example.Spring.boot.Test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    int id;
    String name;
    String description;
}
