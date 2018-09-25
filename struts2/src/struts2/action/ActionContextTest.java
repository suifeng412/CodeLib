package struts2.action;

import java.util.Map;

import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionContextTest extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8593634994807676054L;
	
	public String servletTest() {
		ActionContext actionContext = ActionContext.getContext();
		// 接受参数
		Map<String, Parameter> paramsMap = actionContext.getParameters();
		for(String key : paramsMap.keySet()) {
			Parameter value =  paramsMap.get(key);
			System.out.println(key+"  "+ value.getValue());
		}
		
		actionContext.put("requestName", "张阿三");
		
		actionContext.getSession().put("sessionName", "李阿斯");
		
		actionContext.getApplication().put("applicationName", "刘爱狗");
		
		return SUCCESS;
	}
	
	
}
