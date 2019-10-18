package com.sapient.readers;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sapient.model.PerCapitaIncomeOutput;

public class CsvWriter implements FileWriter {

	private static final String COMMA_DELIMITER = ",";
    private static final String LINE_SEPARATOR = "\n";
    private static final String HEADER = "Country/City,Gender,Income";
	
	@Override
	public void write(List<PerCapitaIncomeOutput> incomes, String path) {
		
		Comparator<PerCapitaIncomeOutput> compare = Comparator
                .comparing(PerCapitaIncomeOutput::getCityOrCountry)
                .thenComparing(PerCapitaIncomeOutput::getGender)
                .thenComparing(PerCapitaIncomeOutput::getAverageIncome);
		
		Collections.sort(incomes,compare);

		try(java.io.FileWriter writer = new java.io.FileWriter(path)){
			
			writer.append(HEADER).append(LINE_SEPARATOR);
			
			for(PerCapitaIncomeOutput income : incomes){
				writer.append(income.getCityOrCountry()).append(COMMA_DELIMITER)
				.append(income.getGender()).append(COMMA_DELIMITER)
				.append(String.valueOf(income.getAverageIncome())).append(LINE_SEPARATOR);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
