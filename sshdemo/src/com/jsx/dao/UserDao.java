package com.jsx.dao;
 
import org.springframework.stereotype.Repository;

import com.jsx.pojo.User;
 
@Repository
public interface UserDao {
	public boolean register(User user);
	public User login(User user);
}
