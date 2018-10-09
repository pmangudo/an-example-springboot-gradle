package com.myspringboot.greeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonalGreetingController {

	@GetMapping("/personalgreeting")
	public String personalgreeting(@RequestParam(name="name",required=false,defaultValue="Mister")String name, Model model) {
		model.addAttribute("name",name);
		return "greeting";
	}
	
}
