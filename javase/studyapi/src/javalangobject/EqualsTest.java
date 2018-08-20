package javalangobject;

public class EqualsTest {
	public static void main(String args[]) {
		Person p1 = new Person(12, "小白");
		Person p2 = new Person(13, "小黑");
		System.out.println(p1.equals(p2));
	}
}

class Person {
	private int uid;
	private String name;

	public Person(int uid, String name) {
		this.setName(name);
		this.setUid(uid);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUid() {
		return this.uid;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Person))
			return false;
		if (((Person) obj).getUid() == this.getUid())
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		int result = 15;
		result = 33 * result + this.getUid();
		return result;
	}

}
