package com.apap.tutorial7.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Airport Detail
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportDetail {
	
	@JsonProperty("value")
	private String value;
	
	@JsonProperty("value")
	private String label;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
