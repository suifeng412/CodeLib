package web22_jsonlib;

import java.util.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * JSON-LIB
 * �ǽ�java������json�����໥ת���Ĺ���
 * ��Ҫ����һЩ��Ҫ�İ�
 * ���ö���
 * JSONObject��java����JavaBean��Map����JSON����ת��������
 * JSONArray��java���ϣ�List��Array����JSON����ת��������
 * �����ࣺ
 * static fromObject(..) ���ڽ�java������߼���׼��Ϊjsonlib����
 * toString() 	��jsonlib����ת��Ϊjson�ַ���
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
