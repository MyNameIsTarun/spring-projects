package com.spring.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	private FortuneService myFortune;
	
	@Autowired
	public TennisCoach(@Qualifier("fileFortuneService") FortuneService myFortune) {
		this.myFortune = myFortune;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your back hand volley";
	}

	@Override
	public String getDailyFortune() {
		return myFortune.getDailyFortune();
	}

//	@Autowired
//	@Qualifier("happyFortuneService")
//	public void anyMethodName(FortuneService myFortune) {
//		this.myFortune = myFortune;
//	}
}
