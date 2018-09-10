package hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * 
 * 
 * 
 * */
public class QueryTest {
	public static void main(String[] args) {
		Session session = getSession();
		test(session);
//		queryTest(session);
//		updateTest(session);
//		delTest(session);
	}

	public static void test(Session session) {
		String hql = "FROM User";
		org.hibernate.query.Query query = session.createQuery(hql);
		List results = query.list();
		System.out.println(results);
	}

	public static void queryTest(Session session) {
		String hql = "SELECT u.name FROM User u WHERE id = 1";
		Query query = session.createQuery(hql);
		List results = ((org.hibernate.query.Query) query).list();
		System.out.println(results);
	}

	public static void updateTest(Session session) {
		String hql = "UPDATE User set name = :name " + "WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("name", "修改");
		query.setParameter("id", 1);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	public static void delTest(Session session) {
		String hql = "DELETE FROM User " + "WHERE :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", 2);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}

	/**
	 * 获取信息
	 * 
	 * @return
	 */
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		return factory.openSession();
	}
}
