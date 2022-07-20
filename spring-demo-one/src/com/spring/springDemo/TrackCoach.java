package com.spring.springDemo;

public class TrackCoach implements Coach {
	
	// Define a private field for the dependency
	private FortuneService fortuneService;
		
	// Define a constructor to inject dependency
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// init method
	public void doMyStartupStuff() {
		System.out.println("Inside init method");
	}
	
	// destroy method
	public void deMyCleanupStuff() {
		System.out.println("Inside destroy method");
	}

}
