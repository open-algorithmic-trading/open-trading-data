package dev.opentrading.data.finnhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.opentrading.data.config.DataConfiguration;
import dev.opentrading.data.entity.FinnhubCandles;
import dev.opentrading.data.finnhub.events.FinnhubDataEvent;

@Component
public class FinnhubDataListener implements ApplicationListener<FinnhubDataEvent> {
	
	@Autowired
	DataConfiguration finnhubDataConfig;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public void onApplicationEvent(FinnhubDataEvent event) {
		FinnhubCandles candles = restTemplate.getForObject(
				"https://finnhub.io/api/v1", FinnhubCandles.class);
	}

}
