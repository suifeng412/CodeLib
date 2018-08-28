package mapapi;

import java.util.WeakHashMap;

/*
 * WeakHashMap
 * 与HashMap的用户基本相同。
 * 区别在于，HashMap的key保留了对实际对象的"强引用"，这意味着只要该HashMap对象不被销毁，该HashMap所引用的对象就不会被垃圾回收。
 * 
 * 但WeakHashMap的key只保留了对实际对象的弱引用，
 * 这意味着如果WeakHashMap对象的key所引用的对象没有被其他强引用变量所引用，
 * 则这些key所引用的对象可能被垃圾回收，
 * 当垃圾回收了该key所对应的实际对象之后，WeakHashMap也可能自动删除这些key所对应的key-value对
 * 
 * 
 * 
 * */
public class WeakHashMapTest {
	public static void main(String[] args) {
		WeakHashMap<String, String> whm = new WeakHashMap<String, String>();
        //将WeakHashMap中添加三个key-value对，
        //三个key都是匿名字符串对象（没有其他引用）
        whm.put(new String("语文") , new String("良好"));
        whm.put(new String("数学") , new String("及格"));
        whm.put(new String("英文") , new String("中等"));

        //将WeakHashMap中添加一个key-value对，
        //该key是一个系统缓存的字符串对象。"java"是一个常量字符串强引用
        whm.put("java" , new String("中等"));
        //输出whm对象，将看到4个key-value对。
        System.out.println(whm);
        //通知系统立即进行垃圾回收
        System.gc();
        System.runFinalization();
        //通常情况下，将只看到一个key-value对。
        System.out.println(whm);
	}
}
