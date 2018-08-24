package collectionapi;

import java.util.*;
/*
 * ArrayDeque
 * 是一个基于数组的双端队列，和ArrayList类似，它们的底层都采用一个动态的、可重分配的Object[]数组来存储集合元素，
 * 当集合元素超出该数组的容量时，系统会在底层重新分配一个Object[]数组来存储集合元素
 * 
 * 
 * 
 * 
 * 
 * */
public class ArrayDequeTest {
	public static void main(String args[]) {
		ArrayDeque<String> stack = new ArrayDeque<String>();
        //依次将三个元素push入"栈"
        stack.push("疯狂Java讲义");
        stack.push("轻量级Java EE企业应用实战");
        stack.push("疯狂Android讲义");

        //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
        System.out.println(stack);

        //访问第一个元素，但并不将其pop出"栈"，输出：疯狂Android讲义
        System.out.println(stack.peek());

        //依然输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
        System.out.println(stack);

        //pop出第一个元素，输出：疯狂Android讲义
        System.out.println(stack.pop());

        //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战]
        System.out.println(stack);
	}
}
