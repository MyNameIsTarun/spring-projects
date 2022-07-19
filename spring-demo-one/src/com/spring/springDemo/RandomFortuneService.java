package com.spring.springDemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String []str = {"You will get some money", "Stay away from dogs today", "Green is good for you"};
	private Random rand = new Random();
	
	@Override
	public String getFortune() {
		return str[rand.nextInt(3)];
	}

}
