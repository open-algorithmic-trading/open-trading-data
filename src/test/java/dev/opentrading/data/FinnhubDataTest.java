package dev.opentrading.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import dev.opentrading.data.config.ConfigProperties;
import dev.opentrading.data.config.DataConfiguration;
import dev.opentrading.data.constants.DataType;
import dev.opentrading.data.constants.Provider;
import dev.opentrading.data.constants.Resolution;
import dev.opentrading.data.finnhub.FinnhubConfiguration;
import dev.opentrading.data.finnhub.FinnhubDataService;
import dev.opentrading.data.util.DataUtil;

/**
 * Simple integration testing module to sanity check changes
 */
@SpringBootTest()
@SpringBootConfiguration
@ComponentScan(basePackageClasses = { 
		DataUtil.class, 
		RestTemplateAutoConfiguration.class, 
		FinnhubConfiguration.class,
		ConfigProperties.class
	})
public class FinnhubDataTest {
	
	@Autowired
	FinnhubDataService finnhubDataService;
	
	@Bean
	public DataConfiguration finnhubDataConfig() {
		return new DataConfiguration(Provider.FINNHUB, DataType.STOCK_CANDLE, Resolution.FIVE);
	}
	
	@Test
	public void getData() {
		finnhubDataService.getTimeBars("SPY", 1);
	}

}
