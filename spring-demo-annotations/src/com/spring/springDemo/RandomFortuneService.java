package com.spring.springDemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {"You will get some money", "stay away from animals", "Walk with care",
								 "Pink is lucky", "Buy some silver"};

	@Override
	public String getDailyFortune() {
		Random rand = new Random();
		return fortunes[rand.nextInt(5)];
	}

}
