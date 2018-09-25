<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>


<a href = "${pageContext.request.contextPath }/demo4.action">demo4 跳转</a> <br/>

<a href = "${pageContext.request.contextPath }/link_check1.action">demo5-1 跳转</a> <br/>
<a href = "${pageContext.request.contextPath }/link_check2.action">demo5-2 跳转</a> <br/>
<a href = "${pageContext.request.contextPath }/link_check3.action">demo4-3 跳转</a> <br/>

<br/>
测试actioncontext<br/>
${reqName}
${sessName}




</body>
</html>