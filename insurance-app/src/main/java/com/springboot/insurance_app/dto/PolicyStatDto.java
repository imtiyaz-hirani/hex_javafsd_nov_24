package com.springboot.insurance_app.dto;

import org.springframework.stereotype.Component;

@Component
public class PolicyStatDto {

	private String label;
	private String data;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
