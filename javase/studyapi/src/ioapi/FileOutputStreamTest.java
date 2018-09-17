package ioapi;

import java.io.*;

/*
 * FileOutputStream
 * 字节文件输出流是用于将数据写入到File，从程序中写入到其他位置。
 * */
public class FileOutputStreamTest {
	public static void main(String[] args) throws IOException {
		stringTest();
		// bytesTest();
		
	}
	
	public static void stringTest() throws IOException {
		String fileName="hello.txt";
	    File f=new File(fileName);
	    OutputStream out =new FileOutputStream(f);
	    String str = "你好，这个是测试。\r\n换行测试";
	    byte[] b = str.getBytes();
	    out.write(b);
	    out.close();
	}
	
	public static void bytesTest() throws IOException {
		String fileName="hello.txt";
        File f=new File(fileName);
        OutputStream out =new FileOutputStream(f);
        String str="你好";
        byte[] b=str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);		// 单字节写入
        }
        out.close();
	}
}
