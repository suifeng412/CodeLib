package threadapi;

/*
 * 常用方法：
 * 
 * 
 * 
 * 
 * 
 * 
 * */
public class DailyUsedMethod {
	public static void main(String[] args) throws InterruptedException {
		test();
		System.out.println("mian结束");
	}
	
	public static void test() throws InterruptedException {
		MethodThread methodThread = new MethodThread("a");
		System.out.println(methodThread.getName());		// 返回此线程名字
		System.out.println(methodThread.getId());		// 返回此线程的名称
		System.out.println(methodThread.getPriority());	// 此线程优先级
		System.out.println(methodThread.isAlive());		// 线程是否处于活动状态 （活动状态就是线程已经启动且尚未终止。线程处于正在运行或准备运行的状态。）
		Thread.sleep(1000);								// 使当前正在执行的线程停止n毫秒
//		methodThread.interrupt(); 						// 中断这个线程
		
		System.out.println(methodThread.isDaemon());	// 是否是守护线程
//		methodThread.setDaemon(true); 					// 标记为daemon线程或者用户线程
		methodThread.join();							// 主线等待子线执行完
//		yield()											// 放弃当前cpu资源
//		setPriority(int newPriority)					// 更改线程的优先级
		
		methodThread.start();
		System.out.println("方法结束");
	}
}

class MethodThread extends Thread {

	public MethodThread(String name) {
		super();
		this.setName(name);		// 将此线程的名称更改为等于参数 name 。
	}

	@Override
	public void run() {
		super.run();
		System.out.println(Thread.interrupted());	// 测试当前线程是否已经是中断状态，执行后具有将状态标志清除为false的功能
		System.out.println(this.isInterrupted());	// 测试线程Thread对相关是否已经是中断状态，但部清楚状态标志
		
		
		System.out.println(MethodThread.currentThread());		// currentThread() 返回当前正在执行的线程对象
	}
}
