package threadapi;

import java.util.ArrayList;
import java.util.List;

/*
 * 等待通知机制
 * 
 * notify		退出等待队列，进入可运行状态
 * notifyAll	全部
 * wait			退出可运行状态，进入等待队列
 * wait(long)
 * wait(long, int)	对于超时时间更细力度的控制，可以达到纳秒
 * 
 * 
 * 当方法wait()被执行后，锁自动被释放，但执行玩notify()方法后，锁不会自动释放。
 * 必须执行完otify()方法所在的synchronized代码块后才释放。
 * 
 * 
 * 当线程呈wait状态时，对线程对象调用interrupt方法会出现InterrupedException异常。
 * 
 * */
public class NotifyWaitTest {
	public static void main(String[] args) {
		try {
			Object lock = new Object();
			ThreadA3 a = new ThreadA3(lock);
			a.start();
			Thread.sleep(50);
			ThreadB3 b = new ThreadB3(lock);
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyList {
	private static List<String> list = new ArrayList<String>();

	public static void add() {
		list.add("anyString");
	}

	public static int size() {
		return list.size();
	}
}

class ThreadA3 extends Thread {
	private Object lock;

	public ThreadA3(Object lock) {
		super();
		this.lock = lock;
	}

	public void run() {
		try {
			synchronized (lock) {
				if (MyList.size() != 5) {
					System.out.println("wait begin" + System.currentTimeMillis());
					lock.wait();
					System.out.println("wait end" + System.currentTimeMillis());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadB3 extends Thread {
	private Object lock;

	public ThreadB3(Object lock) {
		super();
		this.lock = lock;
	}

	public void run() {
		try {
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					MyList.add();
					if (MyList.size() == 5) {
						lock.notify();
						System.out.println("已发出通知！");
					}
					System.out.println("添加了" + (i + 1) + "个元素");
					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
