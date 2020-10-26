package dev.opentrading.data.finnhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import dev.opentrading.data.config.DataConfiguration;
import dev.opentrading.data.entity.FinnhubCandles;

public class FinnhubClient {
	
	@Autowired
	DataConfiguration finnhubDataConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	public FinnhubCandles getCandles() {
		FinnhubCandles candles = restTemplate.getForObject(
				"https://finnhub.io/api/v1", FinnhubCandles.class);
		
		return candles;
	}
	
}
