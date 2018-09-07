package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * 
 * Hibernate常用类：
 * 1、Configuration：配置管理类
 * 		configure([可指定路径]) 加载主配置文件放啊发，默认加载src/hibernate.cfg.xml
 * 		buildSessionFactory()  创建session的工厂对象
 * 2、SessionFactory：Session工厂类，代表hibernate.cfg.xml配置文件
 * 		openSession()  创建一个session对象
 * 		getCurrentSession()  创建session或取出session对象
 * 3、Session对象：数据库的连对象
 * 		session对象维护了一个连接(Connection), 代表了与数据库连接的会话
 * 		beginTransaction() 开启一个事物
 * 		sava(emp)  保存一个对象
 * 		update(emp)  更新一个对象，一定要有主键
 * 		saveOrUpdate(emp)  没有主键则插入，赋值更新，不存在主键则报错
 * 		get(Employee.class, 1)  主键查询
 * 		load(Enployee.class, 1)  主键查询，支持懒加载 
 * 
 * */

public class Test {
	public static void main(String[] args) {
		Session session = getSession();
		//test(session);
		testUpdate(session);
		testSelect(session);
	}
	
	
	public static void testUpdate(Session session) {
		User user = new User();
		user.setId(1);
		user.setName("修改名字");
		user.setPass("6595313");
		session.update(user);
	}
	
	public static void testSelect(Session session) {
		User user = session.get(User.class, 1);
		System.out.println("name："+user.getName()+"|password："+user.getPass());
	}
	
	public static void test(Session session) {
		// 1、加载配置文件
//		Configuration configuration = new Configuration().configure();
		// 2、创建Session工厂
//		SessionFactory factory = configuration.buildSessionFactory();
		// 3、创建Session对象
//		Session session = factory.openSession();
		// 开启事务
		// Transaction tx = session.beginTransaction();
		// 4、操作数据
		System.out.println(session.save(new User("测试", "666666")));
		// 提交事务
        // tx.commit();
		// 5、关闭
		session.close();
	}
	
	public static Session getSession() {
		Configuration configuration = new Configuration().configure();
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		return factory.openSession();
	}
}
