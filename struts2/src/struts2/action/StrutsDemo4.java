package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsDemo4 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute() {
		System.out.println("ActionSupport。。。。");
		return "demo4";
	}

}
