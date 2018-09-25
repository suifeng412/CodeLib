package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsDemo5 extends ActionSupport{



	/**
	 * 
	 */
	private static final long serialVersionUID = 15118296756689965L;

	public String check1() {
		System.out.println("demo5with1");
		return NONE;
	}

	public String check2() {
		System.out.println("demo5with2");
		return NONE;
	}
	
	public String check3() {
		System.out.println("demo5with3");
		return NONE;
	}
}
