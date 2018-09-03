package threadapi;

/*
 * 多个对象多个锁
 * synchribuzed是对象锁
 * 
 * 多个对象读多个锁、异步进行
 * 
 * 
 * 
 * 
 * */
public class SynchronizedTest1 {
	public static void main(String[] args) {
//		ObjectTest t = new ObjectTest();
//		t.setNum(6);
		ObjectTest obj1 = new ObjectTest();
		ObjectTest obj2 = new ObjectTest();
		
		ThreadA athread = new ThreadA(obj1);
		athread.start();
		
		ThreadB bthread = new ThreadB(obj2);
//		ThreadB bthread = new ThreadB(obj1);
		bthread.start();
	}
}


class ObjectTest{
	private int num = 0;
	synchronized public void setNum(Integer i) throws InterruptedException {
		this.num = i;
		System.out.println(num);
		Thread.sleep(2000);
		System.out.println(num*2);
	}
	
	public void getNum() {
		System.out.println(num);
	}
	
}

class ThreadA extends Thread{
	private ObjectTest obj;
	public ThreadA(ObjectTest obj) {
		super();
		this.obj = obj;
	}
	
	public void run() {
		super.run();
		try {
			obj.setNum(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class ThreadB extends Thread{
	private ObjectTest obj;
	public ThreadB(ObjectTest obj) {
		super();
		this.obj = obj;
	}
	
	public void run() {
		super.run();
		try {
			obj.setNum(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
