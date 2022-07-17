package com.spring.springDemo;

public class CricketCoach implements Coach {
	
	// Define a private field for the dependency
	private FortuneService fortuneService;
		
	// Define a constructor to inject dependency
	public CricketCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Ball 50 times then bat for 6 overs";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
