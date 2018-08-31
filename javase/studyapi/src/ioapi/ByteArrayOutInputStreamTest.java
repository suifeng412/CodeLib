package ioapi;

import java.io.*;

/*
  * 内存操作流
  * ByteArrayOutputStream  将内容写入内容
  * ByteArrayInputStream   将内容从内存输出
  * 
  * 
  * 
  * 
  * 
  * 
  * */
public class ByteArrayOutInputStreamTest {
	public static void main(String[] args) throws IOException {
		String str = "ROLLENHOLT";
		ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int temp = 0;
		while ((temp = input.read()) != -1) {
			char ch = (char) temp;
			output.write(Character.toLowerCase(ch));
		}
		String outStr = output.toString();
		input.close();
		output.close();
		System.out.println(outStr);
	}
}
