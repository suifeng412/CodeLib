package struts2.action;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class RequestDemo2 extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 83949241774833462L;

	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> map = request.getParameterMap();
		for(String key : map.keySet()) {
			String[] value = map.get(key);
			System.out.println(key+" "+Arrays.toString(value));
 		}
		
		request.setAttribute("reqName", "reqValue");
		
		request.getSession().setAttribute("sessName", "sessName");
		
		ServletActionContext.getServletContext().setAttribute("appName", "appValue");
		
		return SUCCESS;
	}
	
}
