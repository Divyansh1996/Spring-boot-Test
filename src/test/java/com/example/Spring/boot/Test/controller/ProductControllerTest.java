package com.example.Spring.boot.Test.controller;

import com.example.Spring.boot.Test.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Test
    public void testAddProduct() throws Exception {
        Product product = new Product();
        product.setDescription("Hello Product");
        product.setId(1);
        product.setName("Hello Product");
        objectMapper = new ObjectMapper();

        String productString = objectMapper.writeValueAsString(product);
        System.out.println(productString);
        mockMvc.perform(post("/api/v1/product").content(productString).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


    @Test
    public void testGetProduct() throws Exception {
        String description = "Hello Product";
        mockMvc.perform(get("/api/v1/product/{description}", description).accept(MediaType.ALL)).andExpect(status().isOk());
    }

}
