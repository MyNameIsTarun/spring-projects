package com.spring.springDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
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
	
	@PostConstruct
	public void startupStuff() {
		System.out.println("Inside startupStuff()");
	}
	
	@PreDestroy
	public void cleanupStuff() {
		System.out.println("Inside cleanupStuff()");
	}
	
//	@Autowired
//	public void setFortuneService(FortuneService myFortune) {
//		this.myFortune = myFortune;
//	}

}
