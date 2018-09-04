package threadapi;

/*
 * volatile关键字
 * 线程可以把变量保存本地内存（比如机器的寄存器）中，而不是直接在主存中进行读写。
 * 这就可能造成一个线程在主存中修改了一个变量的值，而另外一个线程还继续使用它在寄存器中的变量值的拷贝，造成数据的不一致。
 * 
 * volatile 修饰的成员变量在每次被线程访问时，都强迫从主存（共享内存）中重读该成员变量的值。
 * 而且，当成员变量发生变化时，强迫线程将变化值回写到主存（共享内存）。
 * 
 * */
public class VolatileTest {
	public static void main(String[] args) throws InterruptedException {
		RunThread thread = new RunThread();
		
		thread.start();
		Thread.sleep(1000);
		thread.setRunning(false);
		
		System.out.println("赋值false");
	}
}

class RunThread{
	// 不加volatile会变是循环 | 或者加一个输出语句、sleep循环会停止=》
	// JVM会尽力保证内存的可见性，即便这个变量没有加同步关键字
	// 此时JVM有空余时间
	volatile private boolean isRunning = true; 
	int m;
	public boolean isRunning() {
		return isRunning;
	}
	public void start() {
		// TODO Auto-generated method stub
		
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public void run() {
		System.out.println("进入run");
		while(isRunning == true) {
			int a = 2;
			int b = 3;
			int c= a+b;
			m=c;
		}
		System.out.println(m);
		System.out.println("线程停止");
	}
}
