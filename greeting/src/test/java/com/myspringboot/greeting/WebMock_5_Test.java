package com.myspringboot.greeting;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/* READ FIFTH:
 To test this controller with @WebMvcTest you can do this
 We use @MockBean to create and inject a mock for the GreetingService (if you don’t 
 do this the application context cannot start), and we set its expectations using Mockito 
 */

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class WebMock_5_Test {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private GreetingService service;
	
	@Test
	public void greetinShouldReturnMessageFromService() throws Exception {
		
		// acá estoy mockeando el servicio para que traiga otra cosa, sino lo hago, lo de abajo falla 
		when(service.greet()).thenReturn("Hello Mock");
		
		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello Mock")));

	}

}
