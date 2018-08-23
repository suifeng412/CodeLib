package collectionapi;

import java.util.*;

/*
 * HashSet
 * 使用HASH算法来存储集合中的元素，因此具有良好的存取和查找性能。
 * add：HashSet会调用该对象的hashCode()获取HashCode，然后根据HashCode决定存放位置
 * add集合判断：通过equals()方法比较且hashCode()方法返回值相等
 * 
 * 
 * =>个人理解Set插入比较
 * 先采用hashCode判断是否相同，不相同则当即插入
 * 其次相同再调用equals()方法再进行对比
 * 
 * */
public class HashSetTest {
	public static void main(String args[]) {
		HashSet<Object> books = new HashSet<Object>();
        //分别向books集合中添加两个A对象，两个B对象，两个C对象
        books.add(new A());
        books.add(new A());

        books.add(new B());
        books.add(new B());

        books.add(new C());
        books.add(new C());
        System.out.println(books);
	}
}

// 明确java Object 中的两个方法
// hashCode() 返回内存地址
// equals() 比较内存地址

// 重写equals 由于每次实例化hashCode都不同 =》即都能入Set
class A {
	public boolean equals(Object obj) {
		System.out.println("A类对象比较");
		return true;
	}
}

// 重写hashCode()方法 由于返回的hashCode相同，需要进一步调用equals()方法比较 =》 即都能入Set
class B {
	public int hashCode() {
		return 1;
	}
	
	// 重写equals() 与父类方法一样，仅仅增加了一个打印语句
	public boolean equals(Object obj) {
		System.out.println("B类对象比较");
        return (this == obj);
    }
}

// 重写hashCode()、equals()方法，且返回值一样 =》 只能入一个
class C {
	public int hashCode() {
		return 2;
	}

	public boolean equals(Object obj) {
		System.out.println("C类对象比较");
		return true;
	}
}