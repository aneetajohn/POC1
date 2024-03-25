package com.oasis.poc1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Oasis_Poc2")
public class Oasis_Poc2 {

	@Id
	@JsonIgnore
	private Integer id;
	private String label_name;
	private String entity_name;
	private String value;
	private String attribute_name;
	private String tooltip;	
	private String saved_timestamp;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel_name() {
		return label_name;
	}
	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}
	public String getEntity_name() {
		return entity_name;
	}
	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAttribute_name() {
		return attribute_name;
	}
	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}
	public String getTooltip() {
		return tooltip;
	}
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	public String getSaved_timestamp() {
		return saved_timestamp;
	}
	public void setSaved_timestamp(String saved_timestamp) {
		this.saved_timestamp = saved_timestamp;
	}
	
	@Override
	public String toString() {
		return "Oasis_Poc2 [id=" + id + ", label_name=" + label_name + ", entity_name=" + entity_name + ", value="
				+ value + ", attribute_name=" + attribute_name + ", tooltip=" + tooltip + ", saved_timestamp="
				+ saved_timestamp + "]";
	}
	
	
}
