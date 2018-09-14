package ioapi;

import java.io.*;

/*
 * FileInputSteam
 * 字节文件输入流
 * 从文件系统中的某个文件中获得输入字节，用于读取诸如图像数据之类的原始字节流。
 * */
public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		byteTest();
	}
	
	public static void byteTest() throws IOException {
		String fileName = "hello.txt";
		File f = new File(fileName);
		InputStream in = new FileInputStream(f);
//		byte[] b = new byte[1024];
		byte[] b=new byte[(int)f.length()];   // 预定长度
		in.read(b);
		in.close();
		System.out.println(new String(b));
		
	}
}
