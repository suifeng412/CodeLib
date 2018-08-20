package stringapi;

/**
 * String 代表字符串，是常量不可变 The value is used for character storage. // private final
 * char value[]; String字符串存放在final修饰的字符数组中
 * 
 * String对象改变字符串时是新建一个字符对象，就对象被GC回收=》效率不高
 * 
 * 常用的api方法： 
 * 1.boolean endsWith(String suffix) 以什么结尾 
 *   boolean startsWith(String prefix)
 * 2.boolean equals(Object other) 
 * 3.boolean equalsIgnoreCase(String other) 
 * 4.int length() 
 * 5.String replace(CharSequence oldString, CharSequence newString) 【连续字符串】
 * 6.String substring(int beginIndex, int endIndex)
 *   String substring(int beginIndex)
 * 7.String toLowerCase()、String toUpperCase()
 * 8.String trim()
 */
public class StringTest {
	public static void main(String args[]) {
		// eg.1
		String s = new String("abc");
		System.out.println(s);
		String s2 = s + "de";
		System.out.println(s2);
		// eg.2
		String str = new String("asdfghjkl");
		System.out.println(str.endsWith("jkl"));
		System.out.println(str.replace("as", "dd"));
		
	}
}

class Mytest {
	private String str;

	public Mytest(String str) {
		this.str = str;
	}
	
	public boolean testEndsWith(String suffix) {
		return this.str.endsWith(suffix);
	}


}
