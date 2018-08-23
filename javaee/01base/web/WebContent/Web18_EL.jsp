<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web17</title>
</head>
<body>
<%--
EL（Expression Language）：目的是jsp写起来更加简洁
语法：${表达式}
内置对象：
1、作用域
	pageScope
	requestScope
	sessionScope
	applicationScope
2、请求参数
	param			// 获得一个参数
	paramValues		// 获得一组参数
3、请求头
	header			// 获取一个请求头
	headerValues	// 获得一组请求头
4、JSP上下文对象
	pageContext
5、全局初始化参数
	initParam
6、cookie
	cookie


.与[]区别
1、[]用于有下标的数据（数组、list集合）.用户有属性的数据（map、对象）
2、如果属性名中包含有特殊的字符.必须使用[]

 --%>
 
 <%
 	// 初始化测试数据
 	pageContext.setAttribute("name", "pageAttributeValue");
 	request.setAttribute("name", "requestAttributeValue");
 %>
 <br/>
  <%-- 使用jsp脚本获得 --%>
	<%=pageContext.getAttribute("name") %>
	<%=request.getAttribute("name") %>
 <br/>
 <%-- 使用EL获取 --%>
 	${ pageScope.name }
 	${ requestScope.name }
 <br/>
 	${ param.username }
 	${ paramValues.nameArr }
 <br/>
 	
 	
 	
 <%--  ==============EL的使用-获取数据 ============  --%>
 <%
 	// 自定义的数据必须存放在作用域中	
 	// 否则${}无法获得
 	String str = "EL的使用，该数据必须存在作用域中";
 %>
 	数据获取：${ str }
 	<br/>
 <%
 	String str1 = "EL的使用，这才是正确的用法";
 	pageContext.setAttribute("testStr", str1);
 %>
 	数据获取：
 	${ testStr } 
 	===== 
	${ pageScope.testStr }
 <br/>
 <%
 	String[] arr = {"aa", "bb", "cc"};
 	pageContext.setAttribute("arr", arr, PageContext.REQUEST_SCOPE);
 %>
 	数组获取：${arr} == ${ arr[1]}
 	
 	
 	
 	
 	
 
 
 
</body>
</html>