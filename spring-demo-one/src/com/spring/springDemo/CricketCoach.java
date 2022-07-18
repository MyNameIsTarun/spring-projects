package com.spring.springDemo;

public class CricketCoach implements Coach {
	
	// Define a private field for the dependency
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
		
	// Define a constructor to inject dependency
//	public CricketCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
	public CricketCoach() {
		System.out.println("CricketCoach: iside no-arg constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: setter injection");
		this.fortuneService = fortuneService;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter setTeam");
		this.team = team;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
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
