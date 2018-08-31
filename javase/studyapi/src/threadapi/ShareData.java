package threadapi;

/*
 * 实例变量和线程安全
 * 
 * 
 * 
 * 
 * 
 * */
public class ShareData {
	public static void main(String[] args) {
		//notShare();
		share();
	}

	public static void notShare() {
		NotShareThrad a = new NotShareThrad("a");
		NotShareThrad b = new NotShareThrad("b");
		NotShareThrad c = new NotShareThrad("c");
		a.start();
		b.start();
		c.start();
	}
	
	public static void share() {
		ShareThread shareThread = new ShareThread();
		Thread a = new Thread(shareThread, "a");
		Thread b = new Thread(shareThread, "b");
		Thread c = new Thread(shareThread, "c");
		Thread d = new Thread(shareThread, "d");
		Thread e = new Thread(shareThread, "e");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
	}
}

 /*
 * 不共享数据线程
 */
class NotShareThrad extends Thread {
	private int count = 5;

	public NotShareThrad(String name) {
		super();
		this.setName(name);
	}

	@Override
	public void run() {
		super.run();
		while (count > 0) {
			count--;
			System.out.println(NotShareThrad.currentThread().getName() + ":" + count);
		}
	}
}

/*
 * 共享数据线程  synchronized关键字使用
 */
class ShareThread extends Thread{
	private int count = 5;
	
	@Override
	synchronized public void run() {
		super.run();
		count--;
		System.out.println(ShareThread.currentThread().getName() + ":" + count);
	}
}


