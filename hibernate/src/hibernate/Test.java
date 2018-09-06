package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		// 1、加载配置文件
        Configuration configuration = new Configuration().configure();
        // 2、创建Session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        // 3、创建Session对象
        Session session = factory.openSession();
        // 4、操作数据
        System.out.println(session.save(new User("测试", "666666")));
        // 5、关闭
        session.close();
	}
}
