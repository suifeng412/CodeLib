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
JSTL标准标准标签库
1、Core  	c
2、l18N  	fmt
3、SQL		sql
4、Function	fn

导入jstl.jar、standard.jar包

<c:if>标签
1、没有标签体的情况下，将结果存放到指定的作用域
<c:if test = "testCondition" var = "result" [scope = "{page|request|response|session|application}"] />
2、有标签体的情况，在标签体中指定要输出的内容
<c:if test = "testCondition" >
	body content
</c:if>
test：用于设置逻辑表达式
var：用户指定逻辑表达式中变量的名字
scope：用于指定百年来那个的范围，默认值为page


<c:forEach>标签
该标签专门用于迭代集合对象中的元素，如Set、List、Map、数组等
1、迭代包含多个对象的集合
<c:forEach [var="varName"] item="collection" [varStatus="varStatusName"] [begin="begin"] [end="ebd"] [step="step"]>
	body content
</c:forEach>
2、迭代指定范围内的集合
<c:forEach [var="varName"] [varStatus="varStatusName"] begin="begin" end="end" [step="step"] >
	body content
</c:forEach>
var：用于指将当前迭代到的元素保存在page域中的名称
items：用于指定将要迭代的集合对象
varStatus：用于指定当前迭代状态信息的对象保存到page域中
	count：1开始
	index：0开始
	first：是否为第一个
	last：是否为最后一个
begin：从0开始
step：步进值



 --%>


<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:out value="测试引入文件"></c:out>

<c:set value = "1" var = "count" property = "count" />
<c:if test = "${count==1}">
	这是输信息
</c:if>
<br/>


<%
	String[] arr = {"aa", "bb", "cc", "dd"};
%>
<c:forEach var="name" items="<%=arr %>">
	${name }<br/>
</c:forEach>





</body>
</html>