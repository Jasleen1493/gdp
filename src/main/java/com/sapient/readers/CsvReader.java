package com.sapient.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sapient.enums.Currency;
import com.sapient.enums.Gender;
import com.sapient.model.PerCapitaIncome;

public class CsvReader implements FileReader {

	public List<PerCapitaIncome> read(String path) {
		List<Object> list = new ArrayList<>();
		List<PerCapitaIncome> incomes = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(path))) {

			list = stream.skip(1).collect(Collectors.toList());

			for (Object item : list) {
				PerCapitaIncome income = new PerCapitaIncome();
				String[] arr = item.toString().split(",");

				income.setCity((String) arr[0]);
				if (arr[1].trim().length() >0){
					income.setCountry(arr[1]);
				}else{
					income.setCountry(null);
				}
				
				income.setGender(Gender.valueOf( arr[2]));
				income.setCurrency(Currency.valueOf(arr[3]));
				income.setAvgIncome(Double.valueOf(arr[4]));
				
				incomes.add(income);
			}
			
			return incomes;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}
