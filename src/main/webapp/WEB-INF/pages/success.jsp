<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Form</title>

</head>
<body>
	<h1><font color="green"><spring:message code="application.description"/></font></h1>
	<h2>${msg}</h2> You have successfully logged in.<br>
	<a href="counter" target="_blank">User counter</a><br>
	<a href="calculator">Calculator</a><br>
	<form action="validateEmail">
	<table> 
	<tr>
	<td><input type="text" name="email"/></td>
	<td><input type="submit" value="Validate Email"/></td>
	</tr>
	<tr>
	<td colspan="2">
	<c:choose>
    	<c:when test="${isEmailValid==true}">
        	<font color="green">
    	</c:when>
    	<c:otherwise>
        	<font color="red">
    	</c:otherwise>
	</c:choose>
	
	${emailStatus}</font></td>
	</tr>
	</table>
	</form>
	<br><br>
	<div>
	<h3>
		Version: <spring:message code="application.version"/>
	</h3>
	</div>
</body>
</html>