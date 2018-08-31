package ioapi;

import java.io.*;

/*
 * OutputStream
 * 字节输出流基类
 * 
 * ByteArrayOutputStream、FileOutputStream 分别向Byte数组、和本地文件中写入数据
 * PipedOutputStream 向与其他线程共用的管道中写入数据
 * ObjectOutputStream和所有FilterOutputStream的子类都是装饰流。
 * 
 * 
 * 
 * 
 * abstract void write(int b)
 * write(byte[] b)
 * write(byte[] b, int off, int len)
 * close()
 * flush()
 * 
 * 
 * OutputStream
 *  FileOutputStream
 *  
 * 
 * */
public class OutputStreamTest {
	public static void main(String[] args) throws IOException {
		test();
		test2();
		test3();
		test4();
	}

	public static void test() {
		OutputStream out = System.out;
		try {
			out.write("hello".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重定向输出
	 */
	public static void test2() {
		System.out.println("重定向之前输出");

		File file = new File("hello.txt");
		try {
			System.setOut(new PrintStream(new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("重定向后的输出666");
	}

	/**
	 * 错误信息重定向
	 */
	public static void test3() {
		File file = new File("error.txt");
		System.err.println("这些在控制台输出");
		try {
			System.setErr(new PrintStream(new FileOutputStream(file)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.err.println("这些在文件中才能看到哦！");
	}

	/**
	 * System.in重定向
	 */
	public static void test4() {
		File file = new File("hello.txt");
		if (!file.exists()) {
			return;
		} else {
			try {
				System.setIn(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			byte[] bytes = new byte[1024];
			int len = 0;
			try {
				len = System.in.read(bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("读入的内容为：" + new String(bytes, 0, len));
		}
	}
}
