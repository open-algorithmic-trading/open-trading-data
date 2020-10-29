package dev.opentrading.data.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinnhubCandles implements Serializable {
	@JsonProperty("o")
	private List<Float> open;
	
	@JsonProperty("c")
	private List<Float> close;
	
	@JsonProperty("h")
	private List<Float> high;
	
	@JsonProperty("l")
	private List<Float> low;
	
	@JsonProperty("v")
	private List<Integer> volume;
	
	@JsonProperty("t")
	private List<Long> timestamp;
	
	@JsonProperty("s")
	private String status;
}
