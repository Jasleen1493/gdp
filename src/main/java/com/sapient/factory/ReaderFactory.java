package com.sapient.factory;

import com.sapient.enums.FileType;
import com.sapient.readers.CsvReader;
import com.sapient.readers.FileReader;

public class ReaderFactory {

	public static FileReader getReader(FileType fileType){
		FileReader reader = null; 
		switch(fileType){
		case CSV:
			reader = new CsvReader();
			break;
		default:
			break;
		}
		return reader;
	}
}
