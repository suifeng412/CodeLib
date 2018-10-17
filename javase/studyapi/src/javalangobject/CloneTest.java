package javalangobject;

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



