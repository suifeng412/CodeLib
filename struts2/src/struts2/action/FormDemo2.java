package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class FormDemo2 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5701541651506580529L;

	private User user;
	
	// 必须提供该get方法
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String execute() {
		System.out.println(user);
		System.out.println(user.name);
		System.out.println(user.age);
		return NONE;
	}
}
