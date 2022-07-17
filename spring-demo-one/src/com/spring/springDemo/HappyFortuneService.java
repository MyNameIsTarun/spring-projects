package com.spring.springDemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You will have a Good day today";
	}

}
