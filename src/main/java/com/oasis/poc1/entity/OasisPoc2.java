package com.oasis.poc1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Oasis_Poc2")
public class OasisPoc2 {

	@Id
	private Integer id;
	@Column(name ="label_name")
	private String labelName;
	@Column(name ="entity_name")
	private String entityName;
	@Column(name ="value")
	private String value;
	@Column(name ="control_type")
	private String controlType;
	@Column(name ="attribute_name")
	private String attribute;
	@Column(name ="tooltip")
	private String tooltip;	
	@Column(name ="saved_timestamp")
	private String timestamp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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
	public String getTooltip() {
		return tooltip;
	}
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "OasisPoc2 [id=" + id + ", labelName=" + labelName + ", entityName=" + entityName + ", value=" + value
				+ ", controlType=" + controlType + ", attribute=" + attribute + ", tooltip=" + tooltip + ", timestamp="
				+ timestamp + "]";
	}
	
	
}
