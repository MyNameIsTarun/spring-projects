package com.spring.springDemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practise long goals";
	}

}
