package com.spring.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService myFortune;

	@Override
	public String getDailyWorkout() {
		return "Practise long goals";
	}

	@Override
	public String getDailyFortune() {
		return myFortune.getDailyFortune();
	}
	
//	@Autowired
	public void setFortuneService(FortuneService myFortune) {
		this.myFortune = myFortune;
	}

}
