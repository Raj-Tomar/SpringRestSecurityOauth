package com.raj.security;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raj.models.ClientDetails;

@SuppressWarnings("deprecation")
@Component
public class UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Transaction tx;
	
	public User getByName(String userName) {
		System.out.println("UserDao");
		User user = null;
		try {
			ClientDetails cd = null;
			
			user = getUser(userName);
			
			if (user == null || user.getName() == null || user.getPassword().equals("")) {
				return new User(userName, "BadUser", new String[] { "ROLE_MAL_ADMIN" });
			} 
			else {
				session = sessionFactory.openSession();
				tx = session.beginTransaction();
				cd = new ClientDetails();
				cd.setAppId(userName);
				cd.setAuthorities("ROLE_ADMIN");
				cd.setAppSecret("secret");
				cd.setGrantTypes("password,authorization_code,refresh_token,implicit");
				cd.setScope("read,write,trust");
				cd.setResourceIds("CS");
				session.saveOrUpdate(cd);
				tx.commit();
				session.close();
				user = new User(userName, "ValidUser", user.getPassword(), new String[] { "ROLE_ADMIN",
						"secret", "password,authorization_code,refresh_token,implicit" });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked" })
	private User getUser(String userName){
		User user = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createSQLQuery("Select password from users where username=?");
			query.setString(0, userName);
			List<Object> status = (List<Object>) query.list();
			String obj = null;
			if(status!=null){
				Iterator<Object> it = status.iterator();
				if (it.hasNext()) {
					byte[] byteArr = (byte[]) it.next();
					obj = new String(byteArr);
				}
				user = new User();
				user.setName(userName);
				user.setPassword(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
