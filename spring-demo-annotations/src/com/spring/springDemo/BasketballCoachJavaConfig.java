package com.spring.springDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketballCoachJavaConfig {
	
	@Bean
	public FortuneService thrillerFortuneService() {
		return new ThrillerFortuneService();
	}

	@Bean
	public Coach basketballCoach() {
		return new BasketballCoach(thrillerFortuneService());
	}
}
