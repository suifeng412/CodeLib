package ioapi;

/*
 * Writer
 * 
 * CharArrayWriter、StringWriter 向Char数组、String中写入数据
 * PipedWriter是向与其它线程共用的管道中写入数据
 * BufferedWriter是一个装饰器为Writer提供缓冲功能。
 * PrintWriter和PrintStream极其类似，功能和使用也非常相似
 * OutputStreamWriter是OutputStream到Writer转换的桥梁
 * 
 * 
 * 写入字符流的抽象类
 * abstract void writer(char[] cbuf, int off, int len)
 * write(char[] cbuf)
 * write(int c)
 * write(String str)
 * write(String str, int off, int len)
 * append(Char c)
 * append(CharSequenec csq)
 * append(CharSequenec csq, int star, int end)
 * abstract void close()
 * abstract void flush()
 * 
 * 
 * 
 * 
 * 
 * */
public class WriterTest {

}
