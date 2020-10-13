package dev.opentrading.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import dev.opentrading.data.config.DataConfiguration;
import dev.opentrading.data.constants.DataType;
import dev.opentrading.data.constants.Provider;
import dev.opentrading.data.constants.Resolution;
import dev.opentrading.data.finnhub.FinnhubDataListener;
import dev.opentrading.data.finnhub.events.FinnhubDataEvent;
import dev.opentrading.data.util.DataUtil;

/**
 * Simple integration testing module to sanity check changes
 */
@SpringBootTest()
public class FinnhubDataListenerTest {
	
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	
	@Test
	public void publishAndReceive() {
		FinnhubDataEvent event = new FinnhubDataEvent(this, "WORK", 1);
		applicationEventPublisher.publishEvent(event);
	}
	
	@SpringBootApplication
	@ComponentScan(basePackageClasses = { FinnhubDataListener.class, DataUtil.class })
    static class TestConfiguration {
		@Bean
		public DataConfiguration finnhubDataConfig() {
			return new DataConfiguration(Provider.FINNHUB, DataType.STOCK_CANDLE, Resolution.FIVE);
		}
    }

}
