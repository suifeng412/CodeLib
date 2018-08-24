package mapapi;

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

}
