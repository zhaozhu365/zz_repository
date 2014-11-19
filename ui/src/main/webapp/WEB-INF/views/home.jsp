<%@page import="org.springframework.http.HttpRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
	<body>
		<h1>
			Hello world!  
		</h1>
	
		<P>  The time on the server is ${serverTime}. </P>
		
		<P>account:    ${account}. </P>
		<P>password:   ${password}. </P>
		<P>seed:       ${seed}. </P>
		<P>name:       ${name}. </P>
		<P>sex:        ${sex}. </P>
		<P>registerTime:${registerTime}. </P>
	
		<br />
		${u.tel }
		<br />
		${u2.tel }
		
		
		测试测试测试~~~~~~~~~~~~
		
		<form action="test1">
			<input type="text" name="name"/>
			<input type="submit" value="提交"/>
		</form>
		
	</body>
</html>
