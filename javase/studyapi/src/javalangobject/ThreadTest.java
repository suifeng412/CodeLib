package javalangobject;

/*
 * 结论：
 * 1、wait(...)方法调用后当前线程将立即阻塞，且适当其所持有的同步代码块中的锁，直到被唤醒或超时或打断后且重新获取到锁后才能继续执行；
 * 2、notify()/notifyAll()方法调用后，其所在线程不会立即释放所持有的锁，直到其所在同步代码块中的代码执行完毕，
 * 此时释放锁，因此，如果其同步代码块后还有代码，其执行则依赖于JVM的线程调度。
 * */
public class ThreadTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		synchronized (r) {
			try {
				System.out.println("main thread 等待t线程执行完");
				r.wait();
				System.out.println("被notity唤醒，得以继续执行");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("main thread 本想等待，但被意外打断了");
			}
			System.out.println("线程t执行相加结果" + r.getTotal());
		}
	}
}

class MyRunnable implements Runnable {
	private int total;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			System.out.println("Thread name is:" + Thread.currentThread().getName());
			for (int i = 0; i < 10; i++) {
				total += i;
			}
			notify();
			System.out.println("执行notif后同步代码块中依然可以继续执行直至完毕");
		}
		System.out.println("执行notif后且同步代码块外的代码执行时机取决于线程调度");
	}

	public int getTotal() {
		return total;
	}
}