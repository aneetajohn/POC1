package com.oasis.poc1.entity;

import java.util.Date;

public class Token {

	private String token;
	private Date expires;
	private boolean ssl;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
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
