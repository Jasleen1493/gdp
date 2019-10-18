package com.sapient.readers;

import java.util.List;

import com.sapient.model.PerCapitaIncomeOutput;

public interface FileWriter {

	public void write(List<PerCapitaIncomeOutput> incomes,String path);
}
