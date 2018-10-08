package hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Session session = getSession();
		// test(session);
		demo1(session);
	}
	
	public static void demo1(Session session) {
		/*
		// 加载配置文件
		Configuration cfg = new Configuration().configure();
		// 创建一个SessionFactory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		// 创建Session 类似于Connection
		Session session = sessionFactory.openSession();
		*/
		// 开启事务
		Transaction tx = session.beginTransaction();
		// 执行操作
		UserInfo userInfo = new UserInfo();
		userInfo.setName("java测试");
		userInfo.setWorkPhone("17324211112");
		userInfo.setUid(12);
		userInfo.setWechat("wecha");
		userInfo.setCompany(3);
		userInfo.setDepartment(4);
		userInfo.setCreatorUid(10023);
		userInfo.setCreatorUid(12);
		userInfo.setRemark("备注");
//		userInfo.setCreatedTime("2016-01-29 17:22:41");
//		userInfo.setUpdatedTime("2016-01-29 17:22:41");
		
		session.save(userInfo);
		//提交事务
		tx.commit();
		// 释放资源
		session.close();
		
		
		
	}
	
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		return factory.openSession();
	}
	
}
