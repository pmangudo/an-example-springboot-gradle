package com.myspringboot.greeting;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/* READ FOURTH:
 
 We can tests only the web layer by using @WebMvcTest
  
 The test assertion is the same as in ApplicationTest.java, but here Spring Boot 
 is only instantiating the web layer, not the whole context.
 In an application with multiple controllers you can even ask for just one to be 
 instantiated, using, for example @WebMvcTest(HomeController.class)
 
 */
	
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class WebLayer_4_Test {
	
	@Autowired
	private MockMvc mocMvc;
	
	@Test
	public void shouldReturnDafaultMessage() throws Exception {
		this.mocMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello World")));
	}

}
