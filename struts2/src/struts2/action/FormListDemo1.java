package struts2.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class FormListDemo1 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2548496661994585739L;
	
	private List<User> list;
	
	public List<User> getList() {
		return list;
	}
	
	public void setList(List<User> list) {
		this.list=list;
	}
	
	public String execute() throws Exception{
		for(User user : list) {
			System.out.println(user);
			System.out.println(user.name);
			System.out.println(user.age);
		}
		return NONE;
	}

}
