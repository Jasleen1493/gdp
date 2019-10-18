package com.sapient.enums;

public enum Gender {
	M("M"), F("F");
	
	private Gender(String gender){
		this.gender= gender;
	}
	
	public final String gender;
	
}
