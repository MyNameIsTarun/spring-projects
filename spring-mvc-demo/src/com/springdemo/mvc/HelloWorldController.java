package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// method to show the html form 
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// method to process the form data
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
}
