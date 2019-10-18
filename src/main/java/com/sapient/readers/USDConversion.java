package com.sapient.readers;

import java.text.DecimalFormat;

import com.sapient.enums.Currency;

public class USDConversion {
	DecimalFormat format = new DecimalFormat("##.00");
	public double calculateCurrency(double income, Currency currency){
		return Double.valueOf(format.format(income/currency.getCurrencyRate()));
	}
	
}

