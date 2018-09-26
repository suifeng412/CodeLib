package struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class FormMapDemo1 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 942417027549799041L;

	private Map<String, User> map;
	
	public Map<String, User> getMap() {
		return map;
	}
	
	public void setMap(Map<String, User> map) {
		this.map = map;
	}
	
	public String execute() throws Exception{
		for(String key : map.keySet()) {
			User user = map.get(key);
			System.out.println(key+" "+user);
			System.out.println(user.name);
			System.out.println(user.age);
		}
		return NONE;
	}
	
}
