package com.oasis.poc1.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Validation {

	private boolean required;
	private Integer minLength;
	
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public Integer getMinLength() {
		return minLength;
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	
	@Override
	public String toString() {
		return "JsonValidation [required=" + required + ", minLength=" + minLength + "]";
	}
	
	
	
}
