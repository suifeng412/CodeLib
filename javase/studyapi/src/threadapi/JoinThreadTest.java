package threadapi;

/*
 * join()
 * join(long millis)中的参数就是设定的等待时间
 * join(long millis, int nanos)
 * 
 * 
 * 
 * 
 * 
 * */
public class JoinThreadTest {
	public static void main(String[] args) throws InterruptedException {
		JoinTest thread = new JoinTest();
		thread.start();
		thread.join();		// 强制等待子线程执行完在往下执行
		System.out.println("我想后执行");
	}
}

class JoinTest extends Thread {
	public void run() {
		// 模拟子线程花费很多时间
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("我想先执行");
	}
}
