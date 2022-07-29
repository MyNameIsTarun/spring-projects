package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// new controller method to read form data and add it to the model
	@RequestMapping("/processFormVersionTwo")
	public String shoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from HTML form
		String name = request.getParameter("studentName");
		
		// manipulate msg
		name = name.toUpperCase();
		
		// create msg
		String result = "YO! "+name;
		
		// add msg to Model
		model.addAttribute("message", result);
		
		return "helloWorld";
	}
}
