package threadapi;

/*
 * 多线程
 * 两种第一线程方式
 * 
 * 
 * 
 * 
 * 
 * 
 * */
public class note {
	public static void main(String[] args) {
		MyThread mythread = new MyThread();
		mythread.start();
		System.out.println("继承main");
		
		Runnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
		System.out.println("实现mian");
	}
}

/*
 * 继承类型实现线程
 */
class MyThread extends Thread{
	@Override
	public void run() {
		super.run();
		System.out.println("我的继承类型线程");
	}
}

/*
 * 实现类型实现线程
 */
class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("我的是实现类型线程");
	}
}





