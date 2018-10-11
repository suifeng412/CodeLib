package aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	
	public  void aopTest() {
		// 创建Spring的工厂类
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 通过工厂解析XML获取的Bean的实例
		OrderDao userDao = (OrderDao) applicationContext.getBean("orderDao");
		userDao.delete();
	}
	
	public  void aopTest2() {
		// 创建Spring的工厂类
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 通过工厂解析XML获取的Bean的实例
		MyAspectXml myAspectXml = (MyAspectXml) applicationContext.getBean("myAspectXml");
		myAspectXml.before();
	}
}
