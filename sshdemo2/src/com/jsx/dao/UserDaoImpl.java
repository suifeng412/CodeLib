package com.jsx.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import com.jsx.pojo.User;

public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public boolean register(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
	public User login(User user) {
		User u = null;
		u = (User)sessionFactory.getCurrentSession().createQuery("from User where username=:username and password=:password")
		.setString("username", user.getUsername())
		.setString("password", user.getPassword()).uniqueResult();
		return u;
	}

}
