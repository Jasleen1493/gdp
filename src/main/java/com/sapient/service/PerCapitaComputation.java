package com.sapient.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.model.PerCapitaIncome;
import com.sapient.model.PerCapitaIncomeOutput;
import com.sapient.readers.USDConversion;

public class PerCapitaComputation {
	
	private USDConversion conversion = new USDConversion();

	public List<PerCapitaIncomeOutput> compute(List<PerCapitaIncome> list){
		
		Map<String,List<PerCapitaIncome>> map = new HashMap<>();
		Map<String,Double> outputMap = new HashMap<>();
		
		for(PerCapitaIncome item : list){
			String key = "";
			if(item.getCountry() == null ||  item.getCountry() == ""){
				key = item.getGender().gender +"-"+item.getCity();
			}else{
				key = item.getGender().gender +"-"+item.getCountry();
			}
			
			map.computeIfAbsent(key,l->new ArrayList<PerCapitaIncome>()).add(item);
			
		}
			
			for(Map.Entry<String,List<PerCapitaIncome>> entry : map.entrySet()){
				List<PerCapitaIncome> countryWiseList = entry.getValue();
				double avgIncome= 0;
				for(PerCapitaIncome income : countryWiseList){
					avgIncome+=conversion.calculateCurrency(income.getAvgIncome(), income.getCurrency());
				}
				avgIncome= avgIncome/countryWiseList.size();
				
				outputMap.put(entry.getKey(), avgIncome);
			}
			
		
		List<PerCapitaIncomeOutput> outputList = new ArrayList<>();
		for(Map.Entry<String,Double> item : outputMap.entrySet()){
			
			PerCapitaIncomeOutput output = new PerCapitaIncomeOutput();
			output.setCityOrCountry(item.getKey().split("-")[1]);
			output.setGender(item.getKey().split("-")[0]);
			output.setAverageIncome(String.valueOf(item.getValue()));
			
			outputList.add(output);
		}
		
		return outputList;
	}
}
