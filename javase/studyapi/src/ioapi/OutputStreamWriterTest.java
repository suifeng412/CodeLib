package ioapi;

import java.io.*;

/*
 * OutputStreamWriter
 * 字节流流转字符流
 * 构造方法：
 * OutputStreamWriter(OutputStream out)
 * OutputStreamWriter(OutputStraem out, Charset cs)
 * OutputStreamWriter(OutputStream out, CharsetEncoder enc)
 * OutputStreamWriter(OutputStream out, String charsetName)
 * 特有方法：
 * String getEncoding()
 * 
 * 
 * */
public class OutputStreamWriterTest {
	public static void main(String[] args) throws IOException {
		String fileName = "hello.txt";
		File file = new File(fileName);
		Writer out = new OutputStreamWriter(new FileOutputStream(file));
		out.write("字节输出流转换为字符输出流");
		out.close();
	}
}
