package com.spring.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		//load the Spring Configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve Beans from Spring Container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//Call methods on the Beans
		System.out.println(theCoach.getDailyWorkout());
		
		//Close the Context
		context.close();
	}

}
