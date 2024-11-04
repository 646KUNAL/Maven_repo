
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.SpringApplication;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // This test will automatically verify if the application context loads successfully.
    }
    
    @Test
    void applicationStarts() {
        String[] args = {};
        DemoApplication application = new DemoApplication();
        assertNotNull(application, "Application instance should not be null");
        SpringApplication.run(DemoApplication.class, args);
    }

    

}
