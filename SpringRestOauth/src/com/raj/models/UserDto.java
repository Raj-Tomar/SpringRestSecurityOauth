package com.raj.models;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = -3995844924015720728L;
	
	private String userName;
	private String password;
	private String authenticationToken;
	private String sessionId;
	
	public UserDto() {
		super();
	}
	
	public UserDto(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthenticationToken() {
		return authenticationToken;
	}
	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
