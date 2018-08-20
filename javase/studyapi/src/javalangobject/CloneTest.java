package javalangobject;

/*
 * protected修饰的属性或方法表示：在同一个包内或者不同包的子类可以访问。
 * (主调者为子类对象的引用才可以；主调者为父类对象引用是则不可以)
 * 
 * clone()的正确调用是需要实现Cloneable接口，如果没有实现Cloneable接口，
 * 并且子类直接调用Object类的clone()方法，则会抛出CloneNotSupportedException异常。
 * 
 * Cloneable接口仅是一个表示接口，接口本身不包含任何方法，用来指示Object.clone()可以合法的被子类引用所调用。
 * 
 * */
public class CloneTest implements Cloneable {
	public static void main(String args[]) {
//		Object obj = new CloneTest();
		CloneTest obj = new CloneTest();
		try {
			CloneTest obj2 = (CloneTest) obj.clone();
			System.out.println("obj:" + obj);
			System.out.println("ot2:" + obj2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
