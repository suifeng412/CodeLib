package struts2.action;

public class StrutsDemo1 {
	
	/**
	 * 提供一个默认的执行方法：execute
	 * return 返回的是一个视图名称
	 * @return
	 */
	public String execute() {
		System.out.println("这是Struts2Demo中的exexute。。。。");
		return "success";
	}
}
