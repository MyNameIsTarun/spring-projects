package com.spring.springDemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Today is a bad day";
	}

}
