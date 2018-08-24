package collectionapi;

import java.util.LinkedHashSet;

/*
 * LinkedHashSet
 * 也是根据hashCode来决定存储位置，但是同时使用链表维护元素的次序，因此元素看起来像有顺序保存
 * 当遍历LinkedHashSet时，将会按照插入顺序进行访问
 * 需要维护链表顺序，因此性能相对于HashSet略低，但是很适合进行数据遍历
 * 
 * 
 * 
 * */
public class LinkedHashSetTest {
	public static void main(String args[]) {
		test();
	}
	
	public static void test() {
		LinkedHashSet<ElementObject> listedset = new LinkedHashSet<ElementObject>();
		ElementObject e1 = new ElementObject("aaaa");
		ElementObject e2 = new ElementObject("bbbb");
		listedset.add(e1);
		listedset.add(e2);
        System.out.println(listedset);
        
        listedset.remove(e1);
        System.out.println(listedset);
	}
}
