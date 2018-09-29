package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		// 创建Spring的工厂类
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 通过工厂解析XML获取的Bean的实例
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.sayHello();
	}
}
