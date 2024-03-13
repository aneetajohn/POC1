package com.oasis.poc1.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Fields {
	
	private String name;
	private String type;
	private String alias;
	private String sqlType;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Integer length;
	private String domain;
	private String defaultValue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getSqlType() {
		return sqlType;
	}
	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	@Override
	public String toString() {		
		return "Fields [name=" + name + ", type=" + type + ", alias=" + alias + ", sqlType=" + sqlType + ", length="
					+ length + ", domain=" + domain + ", defaultValue=" + defaultValue + "]";		
	}
}
