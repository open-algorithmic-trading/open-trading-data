package dev.opentrading.data.config;

import dev.opentrading.data.constants.DataType;
import dev.opentrading.data.constants.Provider;
import dev.opentrading.data.constants.Resolution;

public class DataConfiguration {
	Provider provider;
	DataType type;
	Resolution resolution;
	
	public DataConfiguration(Provider provider, DataType type, Resolution resolution) {
		this.provider = provider;
		this.type = type;
		this.resolution = resolution;
	}
}
