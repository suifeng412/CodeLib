package threadapi;

/*
 * 发生脏读的情况是在读取实例变量时，此值已经被其他线程更改过 
 * 
 * 
 * */
public class SynchronizedTest2 {
	public static void main(String[] args) {
		try {
			PublicVar publicVarRef = new PublicVar();
			ThreadA2 thread = new ThreadA2(publicVarRef);
			thread.start();
			Thread.sleep(200); // 打印结果受此值大小影响
			publicVarRef.getValue();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PublicVar {
	public String username = "A";
	public String password = "AA";

	synchronized public void setValue(String username, String password) {
		try {
			this.username = username;
			Thread.sleep(500);
			this.password = password;

			System.out.println("setValues :" + Thread.currentThread().getName() + " username:" + username + "  password:"
					+ password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getValue() {
		System.out.println(
				"getValues :" + Thread.currentThread().getName() + " username:" + username + "  password:" + password);
	}

}

class ThreadA2 extends Thread {
	private PublicVar publicVar;

	public ThreadA2(PublicVar publicVar) {
		super();
		this.publicVar = publicVar;
	}

	public void run() {
		super.run();
		publicVar.setValue("B", "BB");
	}
}
