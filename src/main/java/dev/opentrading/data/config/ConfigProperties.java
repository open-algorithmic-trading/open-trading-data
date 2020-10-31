package dev.opentrading.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class ConfigProperties {
	
	@Value( "${finnhub.host}" )
	private String finnhubHost;
	
	@Value( "${finnhub.key}" )
	private String finnhubKey;
	
	@Value( "${finnhub.candle.path")
	private String finnhubCandlePath;

}
