<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
   			<h1>用户登录</h1>
   			<s:form action="UserAction_login" namespace="/user" method="post">
   				<s:textfield name="username" label="用户名"></s:textfield>
   				<s:textfield name="password" label="密码"></s:textfield>
   				<s:submit value="登录"></s:submit>
   			</s:form>
   			<h1>用户注册</h1>
   			<s:form action="UserAction_register" namespace="/user" method="post">
   				<s:textfield name="username" label="用户名"></s:textfield>
   				<s:textfield name="password" label="密码"></s:textfield>
   				<s:submit value="注册"></s:submit>
   			</s:form>
  </body>
</html>
