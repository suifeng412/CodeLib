package ioapi;

/*
 * Reader
 * 读取字符流抽象类
 * 
 * CharReader、StringReader 分别从Char数据、String中读取数据
 * PipedReader是从与其它线程共用的管道中读取数据。
 * BufferedReader很明显就是一个装饰器，它和其子类负责装饰其它Reader对象。
 * FilterReader是所有自定义具体装饰流的父类，其子类PushbackReader对Reader对象进行装饰，会增加一个行号。
 * InputStreamReader是一个连接字节流和字符流的桥梁，它将字节流转变为字符流
 * 
 * 
 * abstract int read(char[] cbuf, int off, int len)
 * read()
 * read(char[] cbuf)
 * skip(long n)
 * abstract void close()
 * 
 * Reader
 *  InputStreamReader
 *  BufferedReader
 * 
 * 
 * */
public class ReaderTest {

}
