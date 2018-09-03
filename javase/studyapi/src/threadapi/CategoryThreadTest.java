package threadapi;

/*
 * 多线程分类：
 * 1、用户线程  运行在前台，执行具体任务
 * 2、守护前程  运行在后台，为其他前台线程服务
 * 特点：
 * 一旦所有用户线程都结束运行，守护线程会随JVM一起结束工作
 * 应用：
 * 数据库连接池中的检测线程，JVM虚拟机启动后的检测线程
 * 常见守护线程：
 * 垃圾回收线程
 * 
 * 可以通过调用Thread类的setDaemon(true) 设置当前为守护线程
 * 
 * 注意：
 * 1、setDaemon(true)  必须在start()方法前执行
 * 2、守护线程中创建的新线程也是守护线程
 * 3、不是所有的任务都可以分配给守护线程来执行，比如读写操作或者计算逻辑
 * 
 * 
 * */
public class CategoryThreadTest {
	public static void main(String[] args) {
		try {
			MyThreadDaemon thread = new MyThreadDaemon();
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			System.out.println("end");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThreadDaemon extends Thread{
	private int i = 0;
	
	@Override
	public void run() {
		try {
			while(true) {
				i++;
				System.out.println("i="+i);
				Thread.sleep(100);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
