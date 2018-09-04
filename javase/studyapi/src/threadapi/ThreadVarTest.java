package threadapi;

import java.util.Date;

/*
 * ThreadLocal类
 * 线程变量隔离
 * 缺点：子线程并不能取到父线程的ThreadLocal类的变量
 * InheritableThreadLocal类就是解决这个问题的
 * 如果子线程在取得值的同时，主线程将InheritableThreadLocal中的值进行更改，那么子线程取到的还是旧值
 * get()
 * set()
 * remove()
 * initialValue()
 * 
 * 
 * 
 * 
 * 
 * */
public class ThreadVarTest {
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("mian中取值=" + Tools2.tl.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			ThreadA a = new ThreadA();
			a.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ThreadLocal
	static public class Tools {
		public static ThreadLocalExt tl = new ThreadLocalExt();
	}

	static public class ThreadLocalExt extends ThreadLocal<Object> {
		protected Object initialValue() {
			return new Date().getTime();
		}
	}

	// InheritableThreadLocal
	static public class Tools2 {
		public static InheritableThreadLocalExt tl = new InheritableThreadLocalExt();
	}

	static public class InheritableThreadLocalExt extends InheritableThreadLocal<Object> {
		protected Object initialValue() {
			return new Date().getTime();
		}

		protected Object childValue(Object parentValue) {
			return parentValue + "子线程加的";
		}
	}

	static public class ThreadA extends Thread {
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("线程值取值=" + Tools2.tl.get());
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
