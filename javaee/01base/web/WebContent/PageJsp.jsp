<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page指令笔记</title>
</head>
<body>

<%--
page指令：对页面某些特性进行描述
pageEncoding：指定页面编码格式【在当前页有效】
conentType：有效文档类型
buffer：jsp缓存大小，8kb
autoFlush：是否自动刷新【true|false】
errorPage：指定一个错误页面【jsp页面的相对路径】
isErrorPage：指定该页面是否为错误处理页，如果为true则jsp内置一个Exception对象的exception可直接使用【true|false】
import：导包，可任意个
language：指明解释该jsp页面时采用的语言，默认为java
session：指明该jsp内是否内置Session对象，默认为true，可直接使用session对象，且jsp引擎会自动导入相应的包
<%@ page **** %>
 --%>
	这是一个jsp三大指令中的page指令笔记

<%--
include指令：包含一个静态文件，例如html文件
<%@ include file = "被包含的文件路径" %>
include指令只有一个file属性
--%>
<%@ include file = "/includeTest.html" %>

<%--
taglib指令：用户页面引入标签库
 --%>






</body>
</html>