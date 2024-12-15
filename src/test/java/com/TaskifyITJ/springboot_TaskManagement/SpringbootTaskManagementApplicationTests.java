package com.TaskifyITJ.springboot_TaskManagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This test class ensures that the Spring Boot application context loads successfully.
 * It validates that all configurations, beans, and dependencies are set up correctly.
 */
@SpringBootTest // Tells Spring Boot to load the application context for testing
class SpringbootTaskManagementApplicationTests {

	/**
	 * Tests that the application context loads without any issues.
	 * If the context fails to load, this test will fail, indicating a configuration problem.
	 */
	@Test
	void contextLoads() {
		// Empty test method - the purpose is to check if the context loads successfully.
	}
}
