package com.spring.springDemo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your back hand volley";
	}

}
