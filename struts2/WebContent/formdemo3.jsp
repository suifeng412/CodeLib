<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>属性驱动1-form表单</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/form3.action" method="post">
姓名：<input type="text" name="name" /> <br/>
年龄：<input type="text" name="age" /> <br/>
<input type="submit" value="提交" />

</form>	


</body>
</html>