package com.springdemo.mvc;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private ArrayList<String> os;
	
	//private LinkedHashMap<String, String> countryOptions;
	private ArrayList<String> countryOptions;
	private ArrayList<String> operatingSystems;
	
	public Student() {
		// populate countryOptions with country codes and countries
//		countryOptions = new LinkedHashMap<>();
//		
//		countryOptions.put("IN", "India");
//		countryOptions.put("FR", "France");
//		countryOptions.put("DE", "Germany");
//		countryOptions.put("BR", "Brazil");
		
		countryOptions = new ArrayList<>();
		countryOptions.add("India");
		countryOptions.add("Germany");
		countryOptions.add("Brazil");
		countryOptions.add("France");
		countryOptions.add("United States of America");
		
		operatingSystems = new ArrayList<>();
		operatingSystems.add("Windows");
		operatingSystems.add("Mac OS");
		operatingSystems.add("Linux");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ArrayList<String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public ArrayList<String> getOs() {
		return os;
	}

	public void setOs(ArrayList<String> os) {
		this.os = os;
	}

	public ArrayList<String> getOperatingSystems() {
		return operatingSystems;
	}

//	public LinkedHashMap<String, String> getCountryOptions() {
//		return countryOptions;
//	}
	
}
