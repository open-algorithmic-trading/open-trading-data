package dev.opentrading.data.finnhub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FinnhubConfiguration {
	
	@Bean
	FinnhubClient finnhubClient() {
		return new FinnhubClient();
	}
	
	@Bean
	FinnhubDataService finnhubDataService() {
		return new FinnhubDataService();
	}
	
}
