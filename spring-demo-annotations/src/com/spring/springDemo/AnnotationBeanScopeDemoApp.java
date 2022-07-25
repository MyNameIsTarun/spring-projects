package com.spring.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("footballCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("footballCoach", Coach.class);
		
		System.out.println("Pointing to same object: "+(theCoach == alphaCoach));
		
		System.out.println("Memory location of theCoach: "+theCoach);
		
		System.out.println("Memory location of alphaCoach: "+alphaCoach);
		
		context.close();
	}

}
