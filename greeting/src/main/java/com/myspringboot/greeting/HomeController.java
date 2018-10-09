package com.myspringboot.greeting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping("/")
	public @ResponseBody String greeting() {
		return "Hello World!!!";
	}
}

/*Use @RequestMapping(method=GET) to narrow this mapping

OTHER CONTROLLER
The class is flagged as a @RestController, meaning it’s ready for use 
by Spring MVC to handle web requests. @RequestMapping maps / to the 
index() method. When invoked from a browser or using curl on the command 
line, the method returns pure text. That’s because @RestController 
combines @Controller and @ResponseBody, two annotations that results 
in web requests returning data rather than a view.*/

/*
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
*/
