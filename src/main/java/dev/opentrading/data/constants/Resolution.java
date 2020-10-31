package dev.opentrading.data.constants;

import lombok.Getter;

public enum Resolution {
	ONE("1", 60), 
	FIVE("5", 60 * 5), 
	FIFTEEN("15", 60 * 15), 
	THIRTY("30", 60 * 30), 
	SIXTY("60", 60 * 60), 
	DAY("D", 60 * 60 * 24), 
	WEEK("W", 60 * 60 * 24 * 7);
	
	@Getter
	private String value;
	
	@Getter
	private Integer seconds;

	Resolution(String value, Integer seconds) {
		this.value = value;
		this.seconds = seconds;
	}
}
