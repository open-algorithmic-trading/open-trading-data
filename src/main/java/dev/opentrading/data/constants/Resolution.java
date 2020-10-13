package dev.opentrading.data.constants;

public enum Resolution {
	ONE("1"), 
	FIVE("5"), 
	FIFTEEN("15"), 
	THIRTY("30"), 
	SIXTY("60"), 
	DAY("D"), 
	WEEK("W"), 
	MONTH("M");
	
	String value;

	Resolution(String value) {
		this.value = value;
	}
}
