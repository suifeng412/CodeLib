package stringapi;
/*
 * StringBuffer 是可变字符
 * 默认容量是十六个字符
 * 每次扩容的时候是实际长度*2+2
 * 重新构造字符，拷贝字符到新字符对象中，GC回收旧字符=》为了性能一般都会预估大一点的容量
 * 该类中的方法都是synchronized修饰，线程同步，即是线性安全的
 * 
 * 该类与String没有父子关系，因此不能强制类型转换
 * 改声明方式与String有一些不同点，必须通过new来实例化，不能通过双引号""
 * 
 * 1.StringBuffer() 构造一个控制符
 * 2.int length()
 * 3.StringBuffer append(Char c)  追加字符
 * 4.void setCharAt(int i, char c)  将第下标为i的设置为字符c
 * 5.StringBuffer reverse() 反转
 * 6.String toString()  返回字符串类型字符串
 *  
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
public class StringBufferTest {
	public static void main(String args[]) {

	}
}
