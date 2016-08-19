package com.raj.models;

import java.io.Serializable;

public class SessionTokenDto implements Serializable {

	private static final long serialVersionUID = 4425577176377993910L;
	
	private String sessionId;
	private String createdTime;
	private int sessionLifeTime;
	private String authenticationToken;
	private String userName;
	private String appId;
	private String appName;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public int getSessionLifeTime() {
		return sessionLifeTime;
	}
	public void setSessionLifeTime(int sessionLifeTime) {
		this.sessionLifeTime = sessionLifeTime;
	}
	
	public String getAuthenticationToken() {
		return authenticationToken;
	}
	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
}
