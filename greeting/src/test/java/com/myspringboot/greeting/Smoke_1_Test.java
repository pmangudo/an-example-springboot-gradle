package com.myspringboot.greeting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/* READ FIRST:
 The @SpringBootTest annotation tells Spring Boot to go and look 
 for a main configuration class (one with @SpringBootApplication 
 for instance), and use that to start a Spring application context.
 
 The @Autowired annotation is interpreted by the Spring and the 
 controller is injected before the test methods are run. We are 
 using AssertJ (assertThat() etc.) to express the test assertions.

*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class Smoke_1_Test {
	
	@Autowired
	private HomeController controller;
	
	@Test
	public void contextLoads()throws Exception {
		assertThat(controller).isNotNull();
	}

}

/*
 * A nice feature of the Spring Test support is that the application 
 * context is cached in between tests, so if you have multiple methods 
 * in a test case, or multiple test cases with the same configuration, 
 * they only incur the cost of starting the application once. 
 * You can control the cache using the @DirtiesContext annotation.
 */
