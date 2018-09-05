package threadapi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Lock接口
 * 锁是用于通过多个线程控制对共享资源的访问的工具
 * 在Lock接口出现之前，Java程序是靠synchronized关键字实现锁功能的。
 * Lock是synchronized关键字的进阶
 * 
 * Lock接口的实现类：
 * ReentrantLock
 * ReentrantReadWriteLock.ReadLock
 * ReentrantReadWriteLock.WriteLock
 * 
 * 常见特性：
 * 1、尝试非阻塞地获取锁
 * 2、能被中断地获取锁
 * 3、超时获取锁	
 * 常见方法：
 * 1、lock() 获取锁
 * 2、lockInterruptibly() 同上，但可以中断当前线程
 * 3、newCondition()  获取等待通知组件
 * 4、tryLock()  只有在调用时才可以获得锁，否则立即返回false
 * 5、tryLock(long time, TimeUnit unit)
 * 6、unlock()
 * 
 * 
 * */
public class LockTest {
	public static void main(String[] args) {
		/*
		 * // 简单例子使用 Lock lock = new ReentrantLock(); lock.lock(); try {
		 * 
		 * }finally { lock.unlock(); }
		 */
		
		MyService service = new MyService();
		
		MyThread a1 = new MyThread(service);
		MyThread a2 = new MyThread(service);
		MyThread a3 = new MyThread(service);
		MyThread a4 = new MyThread(service);
		MyThread a5 = new MyThread(service);
		
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();

	}

	static public class MyService {
		private Lock lock = new ReentrantLock();

		public void testMethod() {
			lock.lock();
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println("ThreadName=" + Thread.currentThread().getName()+(" "+ (i+1)));
				}
			} finally {
				lock.unlock();
			}
		}
	}
	
	static public class MyThread extends Thread{
		private MyService service;
		public MyThread(MyService service) {
			super();
			this.service = service;
		}
		
		public void run() {
			service.testMethod();
		}
	}

}
