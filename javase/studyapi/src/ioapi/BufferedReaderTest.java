package ioapi;

import java.io.*;

// 字符缓存流
public class BufferedReaderTest {
	public static void main(String[] args) {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("请输入内容");
		try {
			str = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("你输入的内容是：" + str);
	}
}
