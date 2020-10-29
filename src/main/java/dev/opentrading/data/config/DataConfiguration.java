package dev.opentrading.data.config;

import dev.opentrading.data.constants.DataType;
import dev.opentrading.data.constants.Provider;
import dev.opentrading.data.constants.Resolution;
import lombok.Data;

@Data
public class DataConfiguration {
	private Provider provider;
	private DataType type;
	private Resolution resolution;
	
	public DataConfiguration(Provider provider, DataType type, Resolution resolution) {
		this.provider = provider;
		this.type = type;
		this.resolution = resolution;
	}
}
