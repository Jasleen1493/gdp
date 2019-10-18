package com.sapient.enums;

public enum FileType {

	CSV("csv"),XML("xml");
	
	private String extension;
	private FileType(String extension){
		this.extension=extension;
	}
	
	public String getType(){
		return extension;
	}
}
