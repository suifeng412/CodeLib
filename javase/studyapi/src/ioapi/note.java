package ioapi;

/*
 * IO体系
 * 流式部分=》IO流
 * 非流式部分=》主要包含一些辅助流式部分，例如File类、RandomAccessFile类和FileDescriptor等类
 * 其他类=》文件读取部分的与安全相关的类
 * 
 * IO流（先进先出、顺序存取）
 * 类型分为：字节流、字符流
 * 流向分为：输入流、输出流
 * 
 * 字节流没有缓存区，是直接输出的|字符流式输出到缓冲区
 * =》因此在输出时，字节流将直接输出；字符流只在调用close()方法关闭缓存区时，信息才输出，或者主动调用flush()方法
 * 读的单位不同，字节流以字节（8bit）为单位；字符流以字符为单位，根据码表映射字符
 * 处理对象不同：字节流能处理所有类型的数据（如图片、avi等），而字符流只能处理字符类型的数据。
 * 
 * 
 * 核心：五个类一个接口
 * File、InputStream、OutputStream、Reader、Writer、Serializable
 * RandomAccessFile（随机文件操作）：独立的类，直接继承至Object.它的功能丰富，可以从文件的任意位置进行存取（输入输出）操作。
 * 
   1、File（文件）： FileInputStream, FileOutputStream, FileReader, FileWriter 
   2、byte[]：ByteArrayInputStream, ByteArrayOutputStream 
   3、Char[]: CharArrayReader,CharArrayWriter 
   4、String:StringBufferInputStream, StringReader, StringWriter 
   5、网络数据流：InputStream,OutputStream, Reader, Writer 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
public class note {
	public static void main(String[] args) {

	}
}
