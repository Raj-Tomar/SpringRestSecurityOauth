package com.raj.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.getByName(userName);
		System.out.println("MyUserDetailsService: "+userName);
		if (user == null) {
			throw new UsernameNotFoundException("User " + userName + " not found");
		}
		return new UserContext(user);
	}

}
