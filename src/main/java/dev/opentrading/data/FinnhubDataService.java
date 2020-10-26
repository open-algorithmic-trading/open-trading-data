package dev.opentrading.data;

import dev.opentrading.data.entity.FinnhubCandles;
import dev.opentrading.data.finnhub.FinnhubClient;

public class FinnhubDataService implements StockDataService {
	
	public FinnhubCandles getTimeBars() {
		FinnhubClient client = new FinnhubClient();
		return client.getCandles();
	}
}
