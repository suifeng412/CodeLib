package aopxml;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {
	@Resource(name="orderDao")
	private static OrderDao orderDao;
	
	public static void main(String[] args) {
//		System.out.println(orderDao);
		demo();
//		orderDao.save();
//		orderDao.update();
//		orderDao.delete();
//		orderDao.find();
	}
	
	public static void demo() {
		orderDao.save();
		orderDao.update();
		orderDao.delete();
		orderDao.find();
	}
	

}
