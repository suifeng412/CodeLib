package hibernate;

import java.util.List;

import javax.management.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * HQL查询：
 * HQL查询与SQL查询区别：
 * SQL：（结构化查询语句）查询的是表以及字段；不区分大小写
 * HQL：Hibernate query language即Hibernate提供的面向对象的查询语言。查询的是对象以及对象的属性。区分大小写
 * 
 * Criteria查询:
 * 完全面向对象的查询，也叫QBC，query by criteria
 * 
 * 
 * 本地SQL查询：
 * 原生sql查询
 * 
 * 
 * */
public class SelectSqlWay {
	public static void main(String[] args) {
		Session session = getSession();
		testQuery01(session);
//		testQuery02(session);
	}
	
	public static void testQuery01(Session session) {
		//主键查询
        User emp = (User) session.get(User.class, 1);
        System.out.println(emp);
		
        // HQL查询
		Query q = (Query) session.createQuery("from User where id=1");
        List<User> list = ((org.hibernate.query.Query) q).list();
        System.out.println(list);
        
        session.close();
	}
	
	public static void testQuery02(Session session) {
		// 把每一行记录封装为对象数组，再添加到list集合
		// SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM employee");
		//把每一行记录封装为指定的对象类型
		SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM User").addEntity(User.class);
		List list = sqlQuery.list();
		System.out.println(list);
	}
	
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		return factory.openSession();
	}
}
