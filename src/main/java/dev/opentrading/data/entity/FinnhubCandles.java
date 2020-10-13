package dev.opentrading.data.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FinnhubCandles {
	@JsonProperty("o")
	List<BigDecimal> open;
	
	@JsonProperty("c")
	List<BigDecimal> close;
	
	@JsonProperty("h")
	List<BigDecimal> high;
	
	@JsonProperty("l")
	List<BigDecimal> low;
	
	@JsonProperty("v")
	List<Integer> volume;
	
	@JsonProperty("t")
	List<Long> timestamp;
	
	@JsonProperty("s")
	String status;
}
