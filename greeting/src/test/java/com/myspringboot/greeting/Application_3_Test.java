package com.myspringboot.greeting;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/* READ THIRD:

Another useful approach (diff to HttpRequestTest) is to not start the server at all, 
but test only the layer below that, where Spring handles the incoming HTTP 
request and hands it off to your controller. That way, almost the full 
stack is used, and your code will be called exactly the same way as if 
it was processing a real HTTP request, but without the cost of 
starting the server.

To do that we will use Spring’s MockMvc, and we can ask for that to be 
injected for us by using the @AutoConfigureMockMvc annotation on the test case
 
In this test, the full Spring application context is started, but without the server. 
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // SOLO CONTEXTO PERO SIN EL SERVER (MockMvc)
public class Application_3_Test {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World!!")));

	}
	
	@Test
    public void getHello() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World!!!")));
    }

}
