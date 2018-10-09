package com.jsx.dao;

import com.jsx.pojo.User;

public interface UserDao {
	public boolean register(User user);
	public User login(User user);
}
