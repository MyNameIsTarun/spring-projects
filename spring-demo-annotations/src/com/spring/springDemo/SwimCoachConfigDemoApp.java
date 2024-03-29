package com.spring.springDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimCoachConfigDemoApp {

	public static void main(String[] args) {
		
		// read the Spring Java config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from the Spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call the methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("Email: "+theCoach.getEmail()+"\nTeam: "+theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
