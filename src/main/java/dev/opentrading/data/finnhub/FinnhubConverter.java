package dev.opentrading.data.finnhub;

import org.ta4j.core.BaseBarSeriesBuilder;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.ta4j.core.BarSeries;

import dev.opentrading.data.entity.FinnhubCandles;

public class FinnhubConverter {
	
	public BarSeries convertCandlesToBarSeries(FinnhubCandles candles) {
		BarSeries series = new BaseBarSeriesBuilder().build();
		
		int numCandles = candles.getTimestamp().size();
		
		for (int i = 0; i < numCandles; i++) {
			Long timestamp = candles.getTimestamp().get(i);
			Number open = candles.getOpen().get(i);
			Number close = candles.getClose().get(i);
			Number high = candles.getHigh().get(i);
			Number low = candles.getLow().get(i);
			Number volume = candles.getVolume().get(i);
			
			Instant instant = Instant.ofEpochMilli(timestamp * 1000);
			ZonedDateTime timestampDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
			series.addBar(timestampDateTime, open, high, close, low, volume);
		}
		
		return series;
	}

}
