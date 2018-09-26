package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class FormDemo1 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6723789138362678686L;
	
	private String name;
	
	private Integer age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String execute() {
		System.out.println(name);
		System.out.println(age);
		return NONE;
	}
}
