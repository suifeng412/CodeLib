<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是第一个JSP文件</title>
</head>
<body>
	这是中文
	<%--
JSP语法：
所有可执行的java代码都可以通过JSP脚本来执行
主要包含如下类型：
1、JSP Scriptlets
	JSP Scriptlets是一段代码，用于一些比较复杂的操作或者控制
	<% java 代码  %>
	在这里定义的变量属于局部变量，且不可在里面定义方法（因为java规定方法中不能继续定义方法）、
	一般用于输出
2、JSP 声明语句
	用于声明变量和方法
	<%! 定义变量或者方法 %>
	这里的代码将会被编译在Servlet中的_jspService()方法之外，即成员级别，在整个JSP页面内有效
3、JSP 表达式
	将程序输出到客户端
	<%= 输出的内容（只能写表达式，没有分号;） %>
4、JSP注释
	注释语句入此例

Summarize:
	<% 是在一个方法内写代码 %>
	<%! 是在类中写代码  %>
	<%= 这是一个方便快捷的输出函数 %>
 --%>


	<%!int num = 1, num2 = 2;%>
	<%!public String print() {
		String str = "这是一个字符串";
		return str;
	}%>
	<%
		out.println(num + num2);
	%>
	<br />
	<%
		out.println(print());
	%>


</body>
</html>