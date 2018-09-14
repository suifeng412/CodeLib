# IO体系
> * 流式部分：IO流
> * 非流式部分：主要包含一些辅助流式部分，例如File类、RandomAccessFile类和FileDescriptor等类
> * 其他部分：文件读取部分的与安全相关的类

#### IO流
先进先出、顺序存取
 * 类型分为：字节流、字符流
 * 流向分为：输入流、输出流  
 

* 字节流没有缓存区直接输出
* 字符流存在缓存区，先输出到缓存区，主动flush()或在close()才输出


* 读的单位不同：字节流以字节（8bit）为单位；字符流以字符为单位，根据码表映射字符
* 处理对象不同：字节流能处理所有类型的数据（如图片、avi等），而字符流只能处理字符类型的数据。


> #### BufferedReader

字符缓存流
从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取

构造方法：
 * BufferedRead(Reader in)
 * BufferedRead(Reader in, int sz)  
 
特有方法：
 * String readLine()

```
public class BufferedReaderTest {
	public static void main(String[] args) {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("请输入内容");
		try {
			str = buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("你输入的内容是：" + str);
	}
}
```

> #### InputStreamReader

输入字节流转换为字符流

构造方法
 * InputStreamReader(InputStream in)
 * InputStreamReader(InputStream in, Charset cs)
 * InputStreamReader(InputStream in, CharsetDecoder dec)
 * InputStreamReader(InputStream in, String charasetName)
 * String getEncoding()

```
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
```

> #### FileInputSteam

字节文件输入流  
从文件系统中的某个文件中获得输入字节，用于读取诸如图像数据之类的原始字节流。  

构造方法：
 * FileInputStream(File file)
 * FileInputStream(String name)
 
常用方法：
 * public void close() throws IOException{}
 * protected void finalize()throws IOException {}  清除与该文件的连接
 * public int read(int r)throws IOException{}
 * public int read(byte[] r) throws IOException{}
 * public int available() throws IOException{}

```
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
```














