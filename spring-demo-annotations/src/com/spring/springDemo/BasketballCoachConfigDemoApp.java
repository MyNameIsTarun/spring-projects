package com.spring.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BasketballCoachConfigDemoApp {

	public static void main(String[] args) {
		
		// read the Spring Java config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from the Spring container
		BasketballCoach theCoach = context.getBean("basketballCoach", BasketballCoach.class);
		
		// call the methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
