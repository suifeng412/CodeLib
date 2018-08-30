package ioapi;

/*
 * InputStream
 * 
 * ByteArrayInputStream、StringBufferInputSteam（StreamBufferInputStream）、FileInputStream
 * 是三种的流介质，分别从Byte数组、StringBuffer、和本地文件中读取数据
 * PipedInputStream：是从与其它线程共用的管道中读取数据.
 * ObjectInputStream和所有FilterInputStream的子类都是装饰流（装饰器模式的主角）。
 * 
 * 
 * 
 * 字节输入流基类，抽象类
 * abstract int read() 		// 从输入流读取下一个字节
 * read(byte[] b)
 * read(byte[] b, int off, int len)
 * skip(long n)
 * close()
 * 
 * 
 * InputStream
 *  FileInputStream
 *  FilterInputStream
 *   BufferedInputStream
 * 
 * 
 * 
 * */
public class InputStreamTest {

}
