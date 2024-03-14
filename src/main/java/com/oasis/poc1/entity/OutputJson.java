package com.oasis.poc1.entity;

public class OutputJson {
		
	private String label;
	private String type;
	private String key;
	private String value;
	private Validation validation;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Validation getValidation() {
		return validation;
	}
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	@Override
	public String toString() {
		return "OutputJson [label=" + label + ", type=" + type + ", key=" + key + ", value=" + value + ", validation="
				+ validation + "]";
	}
	
	

}
