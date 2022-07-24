package com.spring.springDemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	@Value("${one}")
	private String one;
	
	@Value("${two}")
	private String two;
	
	@Value("${three}")
	private String three;
	
	@Value("${four}")
	private String four;
	
	private String[] str = {one, two, three, four};
	
	private Random rand = new Random();

	@Override
	public String getDailyFortune() {
		for(String st : str) {
			System.out.println(st);
		}
		return str[rand.nextInt(4)];
	}

}
