package threadapi;

/*
 * 停止线层
 * break
 * return
 * 
 * */
public class StopThreadTest {
	public static void main(String[] args) throws InterruptedException {
		test();
		test2();
	}

	public static void test() {
		try {
			StopThread thread = new StopThread();
			thread.start();
			Thread.sleep(2000);
			thread.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
	
	public static void test2() throws InterruptedException {
		StopThread2 thread2 = new StopThread2();
		thread2.start();
		Thread.sleep(2000);
		thread2.interrupt();
	}
}

class StopThread extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			if(Thread.interrupted()) {
				System.out.println("已经是停止状态了!我要退出了!");
				break;
			}
			System.out.println("i=" + (i + 1));
		}
		System.out.println("看到这句话说明线程并未终止------");
	}

}

class StopThread2 extends Thread{
	@Override
	public void run() {
		while(true) {
			if(this.isInterrupted()) {
				System.out.println("停止");
				return;
			}
			System.out.println("timer=" + System.currentTimeMillis());
		}
	}
}


