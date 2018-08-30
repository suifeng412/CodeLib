package ioapi;

import java.io.*;

public class FileWriterTest {
	public static void main(String[] args) throws IOException {
		test();
	}

	public static void test() throws IOException {
		String fileName = "hello2.txt";
		File f = new File(fileName);
		FileWriter out = new FileWriter(f);
		String str = "我在测试，你好们可以输出么";
		out.write(str);
		out.close();
	}
}
