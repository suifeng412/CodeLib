package throwableapi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// 简单异常测试
		System.out.println("----欢迎使用命令行除法计算器----");
		CMDCalculate();
		try {
			testException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	// FileNotFoundException是IOException的子类
	public static void testException() throws IOException {
		// FileInputStream的构造函数会抛出FileNotFoundException
		FileInputStream fileIn = new FileInputStream("/a.txt");
		int word;
		// read方法会抛出IOException
		while ((word = fileIn.read()) != -1) {
			System.out.print((char) word);
		}
		// close方法会抛出IOException
		fileIn.close();
	}

}
