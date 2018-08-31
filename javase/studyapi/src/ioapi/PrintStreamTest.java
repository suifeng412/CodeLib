package ioapi;

import java.io.*;

/*
 * 打印流
 * PrintStream
 * 
 * 
 * */
public class PrintStreamTest {
	public static void main(String[] args) throws IOException {
        PrintStream print = new PrintStream(new FileOutputStream(new File("hello.txt")));
        print.println(true);
        print.println("Rollen");
        
        String name="Rollen+格式化输出";
        int age=20;
        print.printf("姓名：%s. 年龄：%d.",name,age);
        print.close();
    }
}
