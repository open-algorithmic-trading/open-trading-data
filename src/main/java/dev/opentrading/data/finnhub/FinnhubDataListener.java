package dev.opentrading.data.finnhub;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import dev.opentrading.data.finnhub.events.FinnhubDataEvent;

@Component
public class FinnhubDataListener implements ApplicationListener<FinnhubDataEvent> {

	@Override
	public void onApplicationEvent(FinnhubDataEvent event) {
		// TODO Auto-generated method stub
		
	}

}
