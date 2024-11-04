
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
    public void testHelloWithInvalidPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/invalid"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testHelloWithDifferentMethod() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello/"))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    @Test
    public void testHelloWithRootPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testHelloWithMissingTrailingSlash() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testHelloWithQueryString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/?name=Test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello"));
    }

    @Test
    public void testHelloWithExtraPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello/extra/path"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
