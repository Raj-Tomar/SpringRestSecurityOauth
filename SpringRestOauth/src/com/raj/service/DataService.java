package com.raj.service;

import java.util.List;

import com.raj.security.User;

public interface DataService {
	 
	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public String getAuthenticationToken(String userName, String password);
	/**
	 * @return
	 */
	public List<User> getUserList();
}
