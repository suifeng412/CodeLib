package mapapi;

import java.util.*;

/*
 * TreeMap 
 * 就是一个红黑树数据结构，每一个key-value对即作为红黑树的一个节点，存储是需要根据key对节点进行排序
 * 同理，拥有自然排序和定制排序
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
public class TreeMapTest {
	public static void main(String args[]) {
		TreeMap<R, String> tm = new TreeMap<R, String>();
		tm.put(new R(3), "轻量级Java EE企业应用实战");
		tm.put(new R(-5), "疯狂Java讲义");
		tm.put(new R(9), "疯狂Android讲义");

		System.out.println(tm);

		// 返回该TreeMap的第一个Entry对象
		System.out.println(tm.firstEntry());

		// 返回该TreeMap的最后一个key值
		System.out.println(tm.lastKey());

		// 返回该TreeMap的比new R(2)大的最小key值。
		System.out.println(tm.higherKey(new R(2)));

		// 返回该TreeMap的比new R(2)小的最大的key-value对。
		System.out.println(tm.lowerEntry(new R(2)));

		// 返回该TreeMap的子TreeMap
		System.out.println(tm.subMap(new R(-1), new R(4)));
	}
}

class R implements Comparable<Object> {
	int count;

	public R(int count) {
		this.count = count;
	}

	public String toString() {
		return "R[count:" + count + "]";
	}

	// 根据count来判断两个对象是否相等。
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj != null && obj.getClass() == R.class) {
			R r = (R) obj;
			return r.count == this.count;
		}
		return false;
	}

	// 根据count属性值来判断两个对象的大小。
	public int compareTo(Object obj) {
		R r = (R) obj;
		return count > r.count ? 1 : count < r.count ? -1 : 0;
	}
}