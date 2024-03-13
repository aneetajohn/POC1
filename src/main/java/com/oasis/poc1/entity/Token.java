package com.oasis.poc1.entity;

public class Token {

	private String token;
	private Long expires;
	private boolean ssl;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getExpires() {
		return expires;
	}
	public void setExpires(Long expires) {
		this.expires = expires;
	}
	public boolean isSsl() {
		return ssl;
	}
	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}
	
	@Override
	public String toString() {
		return "Token [token=" + token + ", expires=" + expires + ", ssl=" + ssl + "]";
	}
	
	
	

}
