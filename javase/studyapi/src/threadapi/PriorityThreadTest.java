package threadapi;

/*
 * 线程优先级
 * 每一个线程都有自己的优先级
 * 垃圾回收线程优先级比较低，因此很多垃圾没能够够及时回收
 * 
 * 线程优先级具有继承性：A线程启动B线程，则B线程的优先级和A是一样的。
 * 线程优先级具有随机性：也就是说线程优先级高的不一定每一次都先执行完。
 * 
 * Thread类中包含优先级成员变量：
 * Thread.MINPRIORITY（常数1）
 * Thread.NORMPRIORITY（常数5）
 * Thread.MAXPRIORITY（常数10）
 * 默认线程优先级是5，且线程的优先级在1和10之间
 * 
 * 
 * 
 * 
 * 
 * */
public class PriorityThreadTest {
	public static void main(String[] args) {
		System.out.println("main begin: priority=" + Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main end: priority=" + Thread.currentThread().getPriority());
		MyThreadPri1 thread1 = new MyThreadPri1();
		thread1.start();
	}
}

class MyThreadPri1 extends Thread {
	public void run() {
		System.out.println("pri run priority=" + this.getPriority());
		MyThreadPri2 thread2 = new MyThreadPri2();
		thread2.start();
	}
}

class MyThreadPri2 extends Thread {
	public void run() {
		System.out.println("pri2 run privority=" + this.getPriority());
	}
}
