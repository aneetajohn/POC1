package com.oasis.poc1.entity;

import java.util.Date;

public class OutputJson {
		
	private String entityName;
	private String label;
	private String controlType;
	private String attribute;
	private String value;	
	private Date timestamp;
	
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
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
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "OutputJson [entityName=" + entityName + ", label=" + label + ", controlType=" + controlType
				+ ", attribute=" + attribute + ", value=" + value + ", timestamp=" + timestamp + "]";
	}	

}
