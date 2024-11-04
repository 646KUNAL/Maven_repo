
package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello"));
    }

    @Test
    public void testHelloInvalidPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/world"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    

    @Test
    public void testHelloWithExtraPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/extra"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
