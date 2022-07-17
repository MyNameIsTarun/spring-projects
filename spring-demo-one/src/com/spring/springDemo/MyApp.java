package com.spring.springDemo;

public class MyApp {

	public static void main(String[] args) {
		HappyFortuneService myFortune = new HappyFortuneService();
		
		Coach theCoach = new TrackCoach(myFortune);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
	}

}
