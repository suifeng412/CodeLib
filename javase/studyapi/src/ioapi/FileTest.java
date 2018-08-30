package ioapi;

import java.io.File;
import java.io.IOException;

/*
 * File
 * 用于文件或者目录信息的描述信息
 * 构造方法：
 * 1、File(File parent, String child)
 * 2、File(String pathname)
 * 3、File(String parent, String child)
 * 4、File(URI uri)
 * 
 * 常量：
 * 1、pathSeparator
 * 2、separator
 * 
 * 
 * 主要方法：
 * 1、public boolean createNewFile() throws IOException  
 * 2、public boolean exists()
 * 3、public boolean delete()
 * 4、public boolean isDirectory()
 * 5、public long length()
 * 6、public String[] list()
 * 7、public File[] listFiles() | listFiles(filter）
 * 8、public boolean mkdir() | mkdirs()
 * 9、public boolean renameTo(File dest)
 * 10、canRead() canWrite()
 * 11、isAbsolute()    // 是否为绝对路径
 * 12、createTempFile()  // 创建临时文件
 * 
 * 
 * */
public class FileTest {
	public static void main(String[] args) {
		test();		// 两个常量
		test2();	// 获取文件名路径
		test3();	// 创建文件
	}

	public static void test() {
		System.out.println(File.pathSeparator); // 路径分隔符
		System.out.println(File.separator); // 名称分隔符
	}

	// 获取文件名
	public static void test2() {
		String parentPath = "E:/study/java";
		String name = "HelloWorld.java";
		// 相对路径
		File src = new File(parentPath, name);
		src = new File(new File(parentPath), name);
		// 输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
		// 绝对路径
		src = new File("E:/study/java/HelloWorld.java");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		// 没有盘符: 以 user.dir构建
		src = new File("test.txt"); // 使用相对路径，注意如果在路径中没有盘符，文件则放在工程项目下
//        src =new File(".");
		System.out.println(src.getName()); // test.txt
		System.out.println(src.getPath()); // test.txt
		System.out.println(src.getAbsolutePath()); // G:\DevelopeHome\MyEclipseWorkSpace\Collections\test.txt
		/**
		 * getPath:如果构建文件路径是绝对路径则返回完整路径，否则返回相对路径 getAbsolutePath:返回绝对路径（完整路径）
		 * getCanonicalPath:不但是全路径，而且把..或者.这样的符号解析出来。
		 */
	}
	
	public static void test3() {
		File f=new File("file_io.txt"); 
		if(!f.exists()){  
		    try {  
		        boolean flag = f.createNewFile();  
		        System.out.println(flag?"success":"fail");		//fail  
		    } catch (IOException e) {  
		        // TODO Auto-generated catch block  
		        e.printStackTrace();  
		    }     
		} 
		f.delete(); 
	}
	

}
