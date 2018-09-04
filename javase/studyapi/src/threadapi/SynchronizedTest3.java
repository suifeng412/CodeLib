package threadapi;

/*
 * 同步语句块
 * 可以异步执行对象中非synchronized块的语句，节省时间
 * 
 * 如果两个线程使用了同一个“对象监视器”,运行结果同步，否则不同步.
 * 
 * 
 * synchronized关键字加到static静态方法和synchronized(class)代码块上都是是给Class类上锁，
 * 而synchronized关键字加到非static静态方法上是给对象上锁。
 * 
 * */
public class SynchronizedTest3 {
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread thread1 = new Thread(counter, "A");
		Thread thread2 = new Thread(counter, "B");
		thread1.start();
		thread2.start();
	}
}

class Counter implements Runnable {
	private int count;

	public Counter() {
		count = 0;
	}

	public void countAdd() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
	public void printCount() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " count:" + count);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		if (threadName.equals("A")) {
			countAdd();
		} else if (threadName.equals("B")) {
			printCount();
		}
	}
}
