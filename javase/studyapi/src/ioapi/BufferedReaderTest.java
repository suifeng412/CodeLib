package ioapi;

import java.io.*;

/*
 * BufferedReader
 * 字符缓冲流
 * 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取
 * 构造方法：
 * BufferedRead(Reader in)
 * BufferedRead(Reader in, int sz)
 * 特有方法：
 * String readLine()
 * 
 * 
 * */
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
