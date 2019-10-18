package com.sapient.readers;

import java.util.List;

import com.sapient.model.PerCapitaIncome;

public interface FileReader {
	
	public List<PerCapitaIncome> read(String path);

}
