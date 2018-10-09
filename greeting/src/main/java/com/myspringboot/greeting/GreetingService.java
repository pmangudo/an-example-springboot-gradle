package com.myspringboot.greeting;

import org.springframework.stereotype.Service;


/*
 * The service dependency will be automatically injected by Spring
into the controller (because of the constructor signature)
 */

@Service
public class GreetingService {
	public String greet() {
		return "Hello Everybody";
	}

}
