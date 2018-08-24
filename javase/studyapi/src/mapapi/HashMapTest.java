package mapapi;

import java.util.*;

/*
 * HashMap
 * 和HashSet一样不能保证key-value对的顺序，key的比较和hashSet一样
 * 
 * 
 * 
 * 
 * 
 * 
 * */
public class HashMapTest {
	public static void main(String args[]) {
		HashMap<A, B> hashMap = new HashMap<A, B>();
		hashMap.put(new A(1), new B());
		hashMap.put(new A(2), new B());
		hashMap.put(new A(3), new B());
		hashMap.put(new A(4), new B());
		
		System.out.println(hashMap);
		Set<A> keys = hashMap.keySet();
		for(A a : keys) {
			System.out.println(a.count);
			System.out.println(hashMap.get(a));
		}
	}
}


class A {
	int count;
	public A(int count) {
		this.count = count;
	}
	
	
	public int hashCode() {
		return this.count;
//		return 1;
	}
	
	public boolean equals(Object obj) {
		System.out.println("equals判断");
		if(obj == this)
			return true;
		if(obj != null && obj.getClass() == A.class) {
			A a = (A) obj;
			return this.count == a.count;
		}
		return false;
	}
}


class B {
	public boolean equals(Object obj) {
		return true;
	}
}
