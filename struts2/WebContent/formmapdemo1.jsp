<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/formmap1.action" method="post">
姓名0：<input type="text" name="map'one'].name" /> <br/>
年龄0：<input type="text" name="map['one'].age" /> <br/>
姓名1：<input type="text" name="map['two'].name" /> <br/>
年龄1：<input type="text" name="map['two'].age" /> <br/>
姓名2：<input type="text" name="map['three'].name" /> <br/>
年龄2：<input type="text" name="map['three'].age" /> <br/>
<input type="submit" value="提交" />

</form>	

</body>
</html>