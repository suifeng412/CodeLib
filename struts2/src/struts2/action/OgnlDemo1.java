package struts2.action;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlDemo1 {
	
	public void demo1() throws OgnlException{
		OgnlContext context = new OgnlContext();
		Object obj = Ognl.getValue("'helloword'.length()", context, context.getRoot());
		System.out.println(obj);
	}
	
}
