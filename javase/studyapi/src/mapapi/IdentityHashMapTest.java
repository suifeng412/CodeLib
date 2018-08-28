package mapapi;

import java.util.IdentityHashMap;

/*
 * IdentityHashMap
 * IdentityHashMap的实现机制与HashMap基本相似，
 * 在IdentityHashMap中，当且仅当两个key严格相等(key1 == key2)时，IdentityHashMap才认为两个key相等
 * 
 * */
public class IdentityHashMapTest {
	public static void main(String args[]) {
		IdentityHashMap<String, Integer> ihm = new IdentityHashMap<String, Integer>();
		// 下面两行代码将会向IdentityHashMap对象中添加两个key-value对
		ihm.put(new String("语文"), 89);
		ihm.put(new String("语文"), 78);

		// 下面两行代码只会向IdentityHashMap对象中添加一个key-value对
		ihm.put("java", 93);
		ihm.put("java", 98);
		System.out.println(ihm);

	}
}
