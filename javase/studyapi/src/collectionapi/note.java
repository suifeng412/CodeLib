package collectionapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * Collection
 * 接口基本方法：
 * 1、add(E e)
 * 2、addAll(Collection c)
 * 3、clear()
 * 4、contains(Object o) 	// 集合包含此元素返回ture
 * 5、containsAll(Collection c) 
 * 6、equals(Object o)
 * 7、hashCode()
 * 8、isEmpty()
 * 9、iterator()			// 迭代器
 * 10、remove(Object o)
 * 11、removeAll(Collection c)
 * 12、retainAll(Collection c)  // 仅保留collection中的元素
 * 13、size()
 * 14、toArray()
 * 15、toArray(T[] a) // 指定返回数组类型
 * 
 * 迭代器：
 * boolean hasNext()  // 判断是否还有元素可遍历
 * E next()  // 迭代下一个元素
 * 
 * 
 * 大概分为四种：
 * 1、Set  	无序，唯一 
 * 2、List 	有序(索引)，非唯一
 * 3、Queue  有序，非唯一
 * 4、Map 	映射关系的集合（键值对）
 * 
 * 迭代接口：Iterface Iterable 只有一个方法iterator()
 * 这是Collection类的父接口，只要实现了Iterable就可以进行foreach遍历
 * 
 * Set
 * 与Collection集合基本相同，没有提供额外的方法
 * 不能包含重复的元素、判断元素相等不能使用==，应该采用equals()方法
 * 因此需要注意的是：
 * 	1、为Set集合里面的元素实现一个equals方法
 * 	2、不能传入重复的元素
 * 接口的实现：
 *  HashSet
 *   LinkedHashSet
 *  SortedSet
 *   TreeSet
 *  EnumSet
 *   
 *  List
 *  代表一个有序、可重复的集合，集合中每个元素都有对应的顺序索引
 *  接口的实现：
 *   ArrayList
 *   Vector
 *    Stack
 *   LinkedLink
 *  
 * Queue
 * Queue用于模拟"队列"这种数据结构(先进先出 FIFO)
 *  PrioriQueue
 *  Deque
 *   ArrayDeque
 *   LinkedList
 * 
 * 
 * */


public class note {
	public static void main(String[] args){
		testIteratorStr();
        
		testIterator();
    }
	
	public static void testIteratorStr() {
		List<String> list =Arrays.asList("java语言","C语言","C++语言");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            next = "字符串修改=》相当于new一个新字符串";
        }
        System.out.println(list);
	}
	
	
	public static void testIterator() {
		HashSet<Test> set = new HashSet<Test>();
		Test t1 = new Test("t1，第一个对象");
		Test t2 = new Test("t2，第二个对象");
		Test t3 = new Test("t3，第三个对象");
		set.add(t1);
		set.add(t2);
		set.add(t3);
		Iterator<Test> iterator = set.iterator();
		// 第一次遍历
		while(iterator.hasNext()) {
			Test t = iterator.next();
			System.out.println(t.getStr());
			t.setStr("遍历修改");
		}
		// 第二次遍历
		Iterator<Test> iterator2 = set.iterator();
		while(iterator2.hasNext()) {
			Test t = iterator2.next();
			System.out.println(t.getStr());
		}
	}
	
}



class Test{
	private String str;
	
	public Test(String str) {
		this.str = str;
	}
	
	public String getStr() {
		return this.str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
}
