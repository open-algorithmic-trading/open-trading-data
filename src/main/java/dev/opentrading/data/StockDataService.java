package dev.opentrading.data;
import org.ta4j.core.BarSeries;

public interface StockDataService {
	
	// Gets time bars for a symbol, time bars are aggregates of all market data
	// over a given resolution
	public BarSeries getTimeBars();
	
}
