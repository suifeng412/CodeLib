package ioapi;

import java.io.*;

/*
 * InputStreamReader
 * 输入字节流转换为字符流
 * 构造方法
 * InputStreamReader(InputStream in)
 * InputStreamReader(InputStream in, Charset cs)
 * InputStreamReader(InputStream in, CharsetDecoder dec)
 * InputStreamReader(InputStream in, String charasetName)
 * String getEncoding()
 * 
 * 
 * */
public class InputStreamReaderTest {
	public static void main(String[] args) throws IOException {
		String fileName= "hello.txt";
        File file=new File(fileName);
        Reader read=new InputStreamReader(new FileInputStream(file));
        char[] b=new char[100];
        int len=read.read(b);
        System.out.println(new String(b,0,len));
        read.close();
	}
}
