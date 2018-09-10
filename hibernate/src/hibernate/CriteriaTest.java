package hibernate;

import java.awt.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * Criteria 
 * 标准查询
 *  Hibernate 提供了操纵对象和相应的 RDBMS 表中可用的数据的替代方法。
 *  一种方法是标准的 API，它允许你建立一个标准的可编程查询对象来应用过滤规则和逻辑条件。
 *  
 *  Hibernate Session 接口提供了 createCriteria() 方法，可用于创建一个 Criteria 对象，
 *  使当您的应用程序执行一个标准查询时返回一个持久化对象的类的实例。
 *  
 *  
 * */
public class CriteriaTest {
	public static void main(String[] args) {
		Session session = getSession();
//		test(session);
	}
	
	// 该方法废弃
	public static void test(Session session) {
		Criteria cr = session.createCriteria(User.class);  
		List results = (List) cr.list();  
	}
	
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		return factory.openSession();
	}
}
