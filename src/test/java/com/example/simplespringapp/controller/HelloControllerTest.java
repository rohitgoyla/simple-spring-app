package com.example.simplespringapp.controller;

import com.example.simplespringapp.SimpleSpringAppApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloEndpointShouldReturnHelloMessage() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello from Spring Boot"));
    }

    @Test
    void messageEndpointShouldReturnCustomMessage() throws Exception {
        mockMvc.perform(get("/api/message"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("This is a custom message from the Spring Boot application"));
    }
}