package com.oasis.poc1.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Error {
	
	private Integer code;
	private String message;
	@JsonIgnore
	private String messageCode;
	private List<String> details;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "Error [code=" + code + ", message=" + message + ", details=" + details + "]";
	}
	
	
	
	
}
