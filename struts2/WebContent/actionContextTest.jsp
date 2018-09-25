<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>actioncontext访问servletApi</title>
</head>
<body>

<h1>访问servletApi</h1>
<form action="${pageContext.request.contextPath}/actioncontext1.action" method="post">
姓名：<input type="text" name="name" /> <br/>
年龄：<input type="text" name="age" /> <br/>
<input type="submit" value="提交" />

</form>	

</body>
</html>