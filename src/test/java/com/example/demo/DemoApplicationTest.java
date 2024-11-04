
package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // This test simply ensures that the Spring Application context loads successfully.
    }

    @Test
    void mainMethodTest() {
        // This test ensures that the main method runs without throwing any exceptions.
        assertDoesNotThrow(() -> DemoApplication.main(new String[] {}));
    }

    
}
