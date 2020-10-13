package dev.opentrading.data.finnhub.events;

import org.springframework.context.ApplicationEvent;

public class FinnhubDataEvent extends ApplicationEvent {
	
	String symbol;
	int numPeriods;

	public FinnhubDataEvent(Object source, String symbol, int numPeriods) {
		super(source);
		this.symbol = symbol;
		this.numPeriods = numPeriods;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getNumPeriods() {
		return numPeriods;
	}
	
}
