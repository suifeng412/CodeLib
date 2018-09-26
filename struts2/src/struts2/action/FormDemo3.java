package struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FormDemo3 extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5661839289556991212L;
	
	// 手动构造对象
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	public String execute() throws Exception{
		System.out.println(user);
		System.out.println(user.name);
		System.out.println(user.age);
		return NONE;
	}
	
}