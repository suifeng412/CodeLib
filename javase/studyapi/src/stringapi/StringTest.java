package stringapi;

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
