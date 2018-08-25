package web22_jsonlib;

import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * JSON-LIB
 * 是将java对象与json数据相互转换的工具
 * 需要导入一些必要的包
 * 常用对象：
 * JSONObject：java对象（JavaBean、Map）与JSON数据转换工具类
 * JSONArray：java集合（List、Array）与JSON数据转换工具类
 * 常用类：
 * static fromObject(..) 用于将java对象或者集合准换为jsonlib对象
 * toString() 	将jsonlib对象转换为json字符串
 * 
 * 
 * 
 * */
public class JsonLibTest {
	public static void main(String args[]) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("user1", "lucy");
		map.put("user2", "jack");
		String str = JSONObject.fromObject(map).toString();
		System.out.println(str);
		
		List<Map<String, String>> list = new ArrayList<>();
		list.add(map);
		list.add(map);
		String str2 = JSONArray.fromObject(list).toString();
		System.out.println(str2);
		
		
		
	}
}
