package com.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// remove whitespaces from start and end of string
	// It's a preprocessor which processes web requests before reaching to controller
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("is working");
		StringTrimmerEditor trimmerBinder = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trimmerBinder);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
	}
}
