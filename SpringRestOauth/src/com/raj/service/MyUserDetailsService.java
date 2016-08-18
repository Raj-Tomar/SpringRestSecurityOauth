package com.raj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.raj.dao.UserDao;
import com.raj.models.User;
import com.raj.models.UserContext;

public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.getByLogin(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User " + userName + " not found");
		}
		return new UserContext(user);
	}

}
