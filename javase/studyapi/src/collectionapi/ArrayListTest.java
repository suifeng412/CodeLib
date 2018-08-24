package collectionapi;

import java.util.*;
/*
 * ArrayList
 * 是基于数组实现的List类，它封装了一个动态的增长的、允许再分配的Object[]数组。
 * 
 * 创建的时候可以指定initialCapacity大小，减少重新分配次数
 * 
 * 1、ensureCapacity(int minCapacity)：将ArrayList集合的Object[]数组长度增加minCapacity
 * 2、trimToSize(): 调整ArrayList集合的Object[]数组长度为当前元素的个数。程序可以通过此方法来减少ArrayList集合对象占用的内存空间
 * 
 * 
 * */

public class ArrayListTest {
	public static void main(String args[]) {
		testArrayList();
	}
	
	public static void testArrayList() {
		List<ElementObject> test = new ArrayList<ElementObject>();
        //向books集合中添加三个元素
		test.add(new ElementObject("添加一"));
		test.add(new ElementObject("添加二"));
		test.add(new ElementObject("添加三"));
        System.out.println(test);

        //将新字符串对象插入在第二个位置
        test.add(1 , new ElementObject("新添加"));
        for (int i = 0 ; i < test.size() ; i++ )
        {
            System.out.println(test.get(i).getStr());
        }

        //删除第三个元素
        test.remove(2);
        System.out.println(test);

        //判断指定元素在List集合中位置：输出1，表明位于第二位
        System.out.println(test.indexOf(new ElementObject("添加二"))); 
        //将第二个元素替换成新的字符串对象
        test.set(1, new ElementObject("设置二二二"));
        System.out.println(test);

        System.out.println(test.subList(1 , 2));
	}
}
