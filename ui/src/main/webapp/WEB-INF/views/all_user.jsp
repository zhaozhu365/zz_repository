<%@page import="org.springframework.http.HttpRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach var="u" items="${userList }" >
		<tr>
			<td><c:out value="${u.account }"></c:out></td>
			<td><c:out value="${u.name }"></c:out></td>
			<td><c:out value="${u.sex }"></c:out></td>
			<td><c:out value="${u.tel }"></c:out></td>
			<td><c:out value="${u.registerTime }"></c:out></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>






