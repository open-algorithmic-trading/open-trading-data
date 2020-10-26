package dev.opentrading.data;

import org.ta4j.core.BarSeries;

import dev.opentrading.data.entity.FinnhubCandles;
import dev.opentrading.data.finnhub.FinnhubClient;
import dev.opentrading.data.finnhub.FinnhubConverter;

public class FinnhubDataService implements StockDataService {
	
	public BarSeries getTimeBars() {
		FinnhubClient client = new FinnhubClient();
		FinnhubCandles candles = client.getCandles();
		
		FinnhubConverter converter = new FinnhubConverter();
		return converter.convertCandlesToBarSeries(candles);
	}
}
