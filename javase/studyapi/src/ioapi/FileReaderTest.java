package ioapi;

import java.io.*;

public class FileReaderTest {
	public static void main(String[] args) throws IOException {
		test();
		test2();
	}
	
	public static void test() throws IOException {
		String fileName = "hello2.txt";
		File f = new File(fileName);
		char[] ch = new char[100];
		Reader read = new FileReader(f);
		int count = read.read(ch);
		read.close();
		System.out.println("读入长度为："+count);
		System.out.println("内容为："+new String(ch, 0, count));
	}

	public static void test2() throws IOException {
		String fileName = "hello2.txt";
		File f = new File(fileName);
		char[] ch = new char[100];
		Reader read = new FileReader(f);
		int temp = 0;
		int count = 0;
		while ((temp = read.read()) != (-1)) {
			ch[count++] = (char) temp;
		}
		read.close();
		System.out.println("内容为" + new String(ch, 0, count));
	}
}
