<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator</title>

</head>
<body>
	<h1><font color="green"><spring:message code="application.description"/></font></h1>
	<div>
	<form action="/<spring:message code="application.name"/>/calculator/add">
	<table> 
	<tr>
	<td><input type="text" name="addParam1" value="${addParam1}"/></td>
	<td><input type="button" value="+" disabled="disabled"/></td>
	<td><input type="text" name="addParam2"  value="${addParam2}"/></td>
	<td><input type="submit" value="Add"></td>
	<td><input type="text" value="${addResult}" disabled="disabled"/></td>
	</tr>
	</table>
	</form>
	</div>
	
	<div>
	<form action="/<spring:message code="application.name"/>/calculator/subtract">
	<table> 
	<tr>
	<td><input type="text" name="subParam1" value="${subParam1}"/></td>
	<td><input type="button" value="-" disabled="disabled"/></td>
	<td><input type="text" name="subParam2"  value="${subParam2}"/></td>
	<td><input type="submit" value="Subtract"></td>
	<td><input type="text" value="${subResult}" disabled="disabled"/></td>
	</tr>
	</table>
	</form>
	</div>
	
	<div>
	<form action="/<spring:message code="application.name"/>/calculator/multiply">
	<table> 
	<tr>
	<td><input type="text" name="mulParam1" value="${mulParam1}"/></td>
	<td><input type="button" value="*" disabled="disabled"/></td>
	<td><input type="text" name="mulParam2"  value="${mulParam2}"/></td>
	<td><input type="submit" value="Multiply"></td>
	<td><input type="text" value="${mulResult}" disabled="disabled"/></td>
	</tr>
	</table>
	</form>
	</div>
	
	<div>
	<form action="/<spring:message code="application.name"/>/calculator/divide">
	<table> 
	<tr>
	<td><input type="text" name="divParam1" value="${divParam1}"/></td>
	<td><input type="button" value="/" disabled="disabled"/></td>
	<td><input type="text" name="divParam2"  value="${divParam2}"/></td>
	<td><input type="submit" value="Divide"></td>
	<td><input type="text" value="${divResult}" disabled="disabled"/></td>
	</tr>
	</table>
	</form>
	</div>
</body>
</html>