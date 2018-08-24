package collectionapi;

import java.util.*;

/*
 * TreeSet
 * 是SortedSet接口的实现类，TreeSet可以确保集合元素处于排序状态
 * HashSet集合采用hash算法来决定元素的存储位置
 * TreeSort采用红黑树的数据结构来存储集合元素
 * 支持两种排序：自然排序、定制排序
 * 1、自然排序
 * TreeSet会调用集合元素的compareTo(Object obj)方法来比较元素的大小关系，然后集合按照升序排序
 * 因此该对象的类必须实现Comparable接口
 * 集合不能重复
 * 2、定制排序
 * 实现Comparator接口的int compare(T o1， T o2)方法
 * (类似PHP中的array_map回调处理函数的思想)
 * 
 * 
 * 
 * 
 * */
public class TreeSetTest {

	public static void main(String[] args) {
		testSort();
		
		testTreeSort();
	}
		
	public static void testSort() {
		TreeSet<Integer> nums = new TreeSet<Integer>();
		// 向TreeSet中添加四个Integer对象
		nums.add(5);
		nums.add(2);
		nums.add(10);
		nums.add(-9);

		// 输出集合元素，看到集合元素已经处于排序状态
		System.out.println(nums);

		// 输出集合里的第一个元素
		System.out.println(nums.first());

		// 输出集合里的最后一个元素
		System.out.println(nums.last());

		// 返回小于4的子集，不包含4
		System.out.println(nums.headSet(4));

		// 返回大于5的子集，如果Set中包含5，子集中还包含5
		System.out.println(nums.tailSet(5));

		// 返回大于等于-3，小于4的子集。
		System.out.println(nums.subSet(-3, 4));
	}
	
	public static void testTreeSort() {
		TreeSet<M> ts = new TreeSet<M>(new Comparator()
        {
            //根据M对象的age属性来决定大小
            public int compare(Object o1, Object o2)
            {
                M m1 = (M)o1;
                M m2 = (M)o2;
                return m1.age > m2.age ? -1
                    : m1.age < m2.age ? 1 : 0;
            }
        });    
        ts.add(new M(5));
        ts.add(new M(-3));
        ts.add(new M(9));
        System.out.println(ts);
	}

}


class M
{
    int age;
    public M(int age)
    {
        this.age = age;
    }
    public String toString()
    {
        return "M[age:" + age + "]";
    }
}

