package com.sapient.enums;

public enum Currency {
	INR("INR", 68.89), HKD("HKD", 8.77), SGP("SGP", 50.48), GBP("GBP", 90.95), USD("USD", 1);
	private Currency(String currencyName, double currencyRate) {
		this.currencyRate = currencyRate;
		this.currencyName = currencyName;
	}

	private String currencyName;
	private double currencyRate;

	public String getCurrencyName() {
		return currencyName;
	}

	public double getCurrencyRate() {
		return currencyRate;
	}

}
