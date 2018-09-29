package main;

import org.springframework.stereotype.Component;

@Component(value="userDao")
public class UserDaoImpl implements UserDao {
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("override。。。。。。。");
	}

}
