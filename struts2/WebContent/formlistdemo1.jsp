<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/formlist1.action" method="post">
姓名0：<input type="text" name="list[0].name" /> <br/>
年龄0：<input type="text" name="list[0].age" /> <br/>
姓名1：<input type="text" name="list[1].name" /> <br/>
年龄1：<input type="text" name="list[1].age" /> <br/>
姓名2：<input type="text" name="list[2].name" /> <br/>
年龄2：<input type="text" name="list[2].age" /> <br/>
<input type="submit" value="提交" />

</form>	



</body>
</html>