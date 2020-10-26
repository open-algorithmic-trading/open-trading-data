package dev.opentrading.data.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinnhubCandles {
	@JsonProperty("o")
	List<Float> open;
	
	@JsonProperty("c")
	List<Float> close;
	
	@JsonProperty("h")
	List<Float> high;
	
	@JsonProperty("l")
	List<Float> low;
	
	@JsonProperty("v")
	List<Integer> volume;
	
	@JsonProperty("t")
	List<Long> timestamp;
	
	@JsonProperty("s")
	String status;
}
