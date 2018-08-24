package mapapi;

import java.util.*;

/*
 * LinkedHashMap
 * 使用双向链表来维护key-value对的次序
 * 该链表负责维护Map的迭代顺序，与key-value对的插入顺序一致
 * 
 * 
 * 
 * 
 * 
 * */
public class LinkedHashMapTest {
	public static void main(String args[]) {
		LinkedHashMap<String, Integer> scores = new LinkedHashMap<String, Integer>();
        scores.put("语文" , 80);
        scores.put("英文" , 82);
        scores.put("数学" , 76);
        //遍历scores里的所有的key-value对
        for (Object key : scores.keySet())
        {
            System.out.println(key + "------>" + scores.get(key));
        }
	}
}
