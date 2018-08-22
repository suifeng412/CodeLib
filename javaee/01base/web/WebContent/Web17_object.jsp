<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
jsp中内置了一些需要频繁使用的对象：
1、out       用户页面输出   				javax.servlet.jsp.JspWriter  
2、request	  得到用户的请求信息			javax.servlet.http.HttpservletRequest 
3、response  服务器向客户端的回应信息		javax.servlet.http.HttpservletResponse
4、config	  获取初始化参数				javax.servlet.ServletConfig
5、session	 用来保存用户的信息  			javax.servlet.http.HttpSession
6、application 所有用户共享信息			javax.servlet.ServletContext
7、page		指当前页转换后Servlet类的实例 java.lang.Objcet
8、pageContext JSP页面容器				javax.servlet.jps.PageContext
9、exception jsp页面发生异常，在错误页中才起作用 java.lang.Throwable


out用来向用户发送文本内容，作用ServletResponse.getWriter()方法返回的PrintWriter对象非常像
不同的是：
out对象的类型为JspWriter，相当于一种带缓存功能的PrintWriter
需要调用ServletRespon.getWriter()后才真写


pageContext对象
使用该对象能够后其他的8个隐式对象；代表当前JSP页面的运行环境
1、getOut()
2、getPage()
3、getRequest()
4、getResponse()
5、getSession()
6、getException()
7、getServletConfig()
8、getServletContext()
存储数据通过操作属性来实现：
void setAttribute(String name, Object value, int scope)			设置pageContext对象属性
Object getAttribue(String name, int scope)
void removeAttribue(String name, int scope)
void removeAttribute(String name)		删除所有范围内名称为name的属性
Object findAttribute(String name)		从4个域对象中查找（按照page、request、session、application顺序查找，如果找到则返回属性名字，否则返回null）
scope参数表示作用域范围：
1、PageContext.PAGE_SCOPE			页面范围
2、PageContext.REQUEST_SCOPE			请求范围
3、PageContext.SESSION_SCOPE			会话范围
4、PageContext.APPLICATION_SCOPE		Web应用程序范围



JSP动作元素
1、<jsp:include>动作元素
<jsp:include page="relationURL" flush="true|false" />
page：被引入资源的相对路径
flush：用于指定是否将当前页面输出内容刷新到客户端，默认情况下为false

 --%>


<%
	out.println("这是内置对象out<br/>");
	
	out.println("测试先后：第一行<br/>");
	response.getWriter().println("测试先后：第二行<br/>");

%>


<%
	// 获取request对象
	HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
	// 设置page范围内属性
	pageContext.setAttribute("str", "1这是设置page属性", PageContext.PAGE_SCOPE);
	// 设置的request范围内属性
	req.setAttribute("str", "2这是request中的属相");
	
	// 获取page属性
	String str1 = (String) pageContext.getAttribute("str", PageContext.PAGE_SCOPE);
	// 获取request属性
	String str2 = (String) pageContext.getAttribute("str", PageContext.REQUEST_SCOPE);
%>

<%="page范围："+str1 %><br/>
<%="request范围："+str2 %><br/>






</body>
</html>