package collectionapi;

import java.util.LinkedList;

/*
 * LinkedList
 * implements List<E>, Deque<E>
 * 实现Deque接口 将LinkedLink当做双端队列
 * 也可以被当做栈来使用
 * 
 * 
 * 
 * 
 * 
 * */
public class LinkedListTest {
	public static void main(String args[]) {
		LinkedList<String> books = new LinkedList<String>();

        //将字符串元素加入队列的尾部(双端队列)
        books.offer("疯狂Java讲义");

        //将一个字符串元素加入栈的顶部(双端队列)
        books.push("轻量级Java EE企业应用实战");

        //将字符串元素添加到队列的头(相当于栈的顶部)
        books.offerFirst("疯狂Android讲义");

        for (int i = 0; i < books.size() ; i++ )
        {
            System.out.println(books.get(i));
        }

        //访问、并不删除栈顶的元素
        System.out.println(books.peekFirst());
        //访问、并不删除队列的最后一个元素
        System.out.println(books.peekLast());
        //将栈顶的元素弹出"栈"
        System.out.println(books.pop());
        //下面输出将看到队列中第一个元素被删除
        System.out.println(books);
        //访问、并删除队列的最后一个元素
        System.out.println(books.pollLast());
        //下面输出将看到队列中只剩下中间一个元素：
        //轻量级Java EE企业应用实战
        System.out.println(books);
	}
}
