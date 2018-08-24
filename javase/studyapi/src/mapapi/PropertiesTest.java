package mapapi;

import java.io.*;
import java.util.*;

/*
 * Properties
 * 把Map对象和属性文件关联起来
 * =》可以Map对象中的key-value对写入到属性文件
 * =》可以把属性文件中的属性名-属性值加载到Map对象中
 * 
 * 
 * 
 * 
 * 
 * 
 * */
public class PropertiesTest {
	public static void main(String args[]) throws Exception {
		Properties props = new Properties();
        //向Properties中增加属性
        props.setProperty("username" , "yeeku");
        props.setProperty("password" , "123456");

        //将Properties中的key-value对保存到a.ini文件中
        props.store(new FileOutputStream("properties.ini"), "comment line");   //①

        //新建一个Properties对象
        Properties props2 = new Properties();
        //向Properties中增加属性
        props2.setProperty("gender" , "male");

        //将a.ini文件中的key-value对追加到props2中
        props2.load(new FileInputStream("properties.ini") );    //②
        System.out.println(props2);
	}
}
