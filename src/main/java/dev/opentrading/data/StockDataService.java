package dev.opentrading.data;
import dev.opentrading.data.entity.FinnhubCandles;

public interface StockDataService {
	
	// Gets time bars for a symbol, time bars are aggregates of all market data
	// over a given resolution
	public FinnhubCandles getTimeBars();
	
}
