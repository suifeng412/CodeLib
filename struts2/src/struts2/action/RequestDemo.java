package struts2.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class RequestDemo extends ActionSupport implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8508862246670363969L;

	HttpServletRequest request;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() throws Exception {
		System.out.println("测试看有没有访问");
		request.setAttribute("message", "request.....");
		return SUCCESS;
	}

}
