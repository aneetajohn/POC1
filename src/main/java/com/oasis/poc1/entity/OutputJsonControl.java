package com.oasis.poc1.entity;

public class OutputJsonControl {
		
	private String label;
	private String controlType;
	private String attribute;
	private String value;
	private String tooltip;
	private Validation validation;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getControlType() {
		return controlType;
	}
	public void setControlType(String controlType) {
		this.controlType = controlType;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTooltip() {
		return tooltip;
	}
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	public Validation getValidation() {
		return validation;
	}
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	@Override
	public String toString() {
		return "OutputJson [label=" + label + ", controlType=" + controlType + ", attribute=" + attribute + ", value="
				+ value + ", tooltip=" + tooltip + ", validation=" + validation + "]";
	}
	
	
	
	
	
	

}
