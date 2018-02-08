package com.xakj.model.dto;

import java.io.Serializable;

public class Principal implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public Principal(){
		
	}
	public Principal(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}

}
