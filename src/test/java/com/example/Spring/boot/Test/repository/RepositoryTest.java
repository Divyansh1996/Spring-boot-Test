package com.example.Spring.boot.Test.repository;

import com.example.Spring.boot.Test.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        Product product = new Product();
        product.setDescription("Hello Product");
        product.setId(1);
        product.setName("Hello Product");
        productRepository.save(product);
    }

    @AfterEach
    public void tearDown() {
        productRepository.deleteById(1);
    }

    @Test
    public void testFindByDescription() {
        Product productByDescription = productRepository.getProductByDescription("Hello Product");
        String description = productByDescription.getDescription();
        assertEquals(description, "Hello Product");
    }
}
