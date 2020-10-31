package dev.opentrading.data.finnhub;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import dev.opentrading.data.config.DataConfiguration;
import dev.opentrading.data.entity.FinnhubCandles;

public class FinnhubClient {
	
	@Autowired
	DataConfiguration finnhubDataConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Environment env;
	
	public FinnhubCandles getCandles(String symbol, int numPeriods) {
		String finnhubHost = env.getProperty("finnhub.host");
		String apiKey = env.getProperty("finnhub.key");
		String path = env.getProperty("finnhub.candle.path");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("X-Finnhub-Token", apiKey);
		
		// Having some trouble getting different times to work here, maybe related to trading hours
		// Setting current time to 1572651390L successfully pulls a single period (but an old one)
		Long currentTime = Instant.now().toEpochMilli() / 1000L;
		Long startTime = currentTime - finnhubDataConfig.getResolution()
				.getSeconds()*(numPeriods + 1);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(finnhubHost + path)
				.queryParam("symbol", symbol)
				.queryParam("resolution", finnhubDataConfig.getResolution().getValue())
				.queryParam("from", startTime)
				.queryParam("to", currentTime)
				.queryParam("token", apiKey);
		        
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		HttpEntity<FinnhubCandles> response = restTemplate.exchange(
		        builder.toUriString(),
		        HttpMethod.GET,
		        entity,
		        FinnhubCandles.class);
		
		return response.getBody();
	}
	
}
