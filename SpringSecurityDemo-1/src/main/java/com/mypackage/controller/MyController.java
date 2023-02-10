package com.mypackage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController: It can be considered as a combination of 
//@Controller and @ResponseBody annotations. 
//The @RestController annotation is itself annotated with the @ResponseBody annotation. 
//It eliminates the need for annotating each method with @ResponseBody.
@RestController
public class MyController {
	
	@GetMapping("/log")
	public String login() {
		return "You have logged-in successfully";
	}
}
