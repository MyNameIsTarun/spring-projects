package com.spring.springDemo;

public class BaseballCoach implements Coach {
	
	// Define a private field for the dependency
	private FortuneService fortuneService;
	
	// Define a constructor to inject dependency
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
