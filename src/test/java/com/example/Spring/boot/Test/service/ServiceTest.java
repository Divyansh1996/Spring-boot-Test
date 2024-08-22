package com.example.Spring.boot.Test.service;

import com.example.Spring.boot.Test.model.Product;
import com.example.Spring.boot.Test.repository.ProductRepository;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void addProductTest(){
        Product product = new Product();
        product.setDescription("Hello Product");
        product.setId(1);
        product.setName("Hello Product");

        when(productRepository.save(product)).thenReturn(product);
        String result = productService.addProduct(product);
        assertThat(result, result.equals("Product added"));
    }

    @Test
    public void getProductTest(){
        String description = "Hello Product";

        Product product = new Product();
        product.setId(1);
        product.setName("Hello Product");
        product.setDescription("Hello Product");

        when(productRepository.getProductByDescription(description)).thenReturn(product);
        Product productByDescription = productService.getProductByDescription(description);

        assertEquals(productByDescription, product);
    }

}
