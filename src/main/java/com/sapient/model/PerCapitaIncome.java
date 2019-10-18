package com.sapient.model;

import com.sapient.enums.Currency;
import com.sapient.enums.Gender;

public class PerCapitaIncome {
	
	private String country;
	private String city;
	Currency currency;
	Gender gender;
	double avgIncome;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public double getAvgIncome() {
		return avgIncome;
	}
	public void setAvgIncome(double avgIncome) {
		this.avgIncome = avgIncome;
	}
	
	
	

}
