package aopxml;


public class Test {

	public static void main(String[] args) {

		demo();
		
		demo2();
		

	}
	
	public static void demo() {
		AopTest atest = new AopTest();
		atest.aopTest();
	}
	
	public static void demo2() {
		AopTest atest = new AopTest();
		atest.aopTest2();
	}
	

}
