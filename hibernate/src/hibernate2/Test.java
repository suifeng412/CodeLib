package hibernate2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Test {
	public static void main(String[] args) {
		Session session = getSession();
		// test(session);
//		demo1(session);
		
		demoQuery(session);
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
		//Transaction tx = session.beginTransaction();
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
		//tx.commit();
		// 释放资源
		session.close();
		
		
		
	}
	
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		return factory.openSession();
	}
	
	@SuppressWarnings("unchecked")
	public static void demoQuery(Session session) {
		Query<UserInfo> query = session.createQuery("from UserInfo");
//		query.setParameter("name", "随风");
//		query.setParameter("phone", "17324211111");
//		query.setString("name", "随风");
//		query.setString("phone", "17324211111");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<UserInfo> list = (List<UserInfo>) query.list();
		System.out.println(list);
		
	}

//	public static void demoCriteria(Session session) {
//		Criteria criteria = session.createCriteria("UserInfo.class");
//	}
	
//	public static void demoSql(Session session) {
//		SQLQuery sqlQuery = session.createSQLQuery("select*from admin_userinfo");
//	}
	
}
