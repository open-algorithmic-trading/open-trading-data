package dev.opentrading.data.finnhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.ta4j.core.BarSeries;

import dev.opentrading.data.StockDataService;
import dev.opentrading.data.entity.FinnhubCandles;

public class FinnhubDataService implements StockDataService {
	
	@Autowired
	FinnhubClient finnhubClient;
	
	public BarSeries getTimeBars(String symbol, int numPeriods) {
		FinnhubCandles candles = finnhubClient.getCandles(symbol, numPeriods);
		
		FinnhubConverter converter = new FinnhubConverter();
		return converter.convertCandlesToBarSeries(candles);
	}
}
