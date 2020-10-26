package dev.opentrading.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import dev.opentrading.data.config.DataConfiguration;
import dev.opentrading.data.constants.DataType;
import dev.opentrading.data.constants.Provider;
import dev.opentrading.data.constants.Resolution;
import dev.opentrading.data.util.DataUtil;

/**
 * Simple integration testing module to sanity check changes
 */
@SpringBootTest()
public class FinnhubDataTest {
	
	@SpringBootApplication
	@ComponentScan(basePackageClasses = { DataUtil.class })
    static class TestConfiguration {
		
		@Test
		public void getData() {
		}
		
		@Bean
		public DataConfiguration finnhubDataConfig() {
			return new DataConfiguration(Provider.FINNHUB, DataType.STOCK_CANDLE, Resolution.FIVE);
		}
    }

}
