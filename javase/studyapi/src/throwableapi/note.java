package throwableapi;

import java.util.Scanner;

/*
 * Throwable是所有异常顶层父类 包含Error类、Execption类
 * 错误：Error类代表JVM本身错误，通过代码不能够处理，比较少出现
 * 异常：Exception类，代表程序运行时发生的各种不期望发生的事件，能够被异常机制捕获处理，是异常处理的核心
 * 
 * 针对javac编译来说可以分为两类，检查异常和非检查异常
 * 检查异常：IOException javac要求强制为这些异常做好预备工作，否则不通过编译。（如SQLException , IOException,ClassNotFoundException 等。）
 * 非检查异常：Error、RuntimeException 例如，使用空对象导致的NullPointerException
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
public class note {
	public static void main(String[] args) {
		//简单异常测试
		System.out.println("----欢迎使用命令行除法计算器----");
		CMDCalculate();
	}

	public static void CMDCalculate() {
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int result = devide(num1, num2);
		System.out.println("result:" + result);
		scan.close();
	}

	public static int devide(int num1, int num2) {
		return num1 / num2;
	}
}
