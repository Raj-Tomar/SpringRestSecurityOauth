<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<c:url var="userLogin" value="/login"/>
<form action="${userLogin}" method="POST">
	<table align="center" style="margin-top: 150px;">
		<tr>
			<td>User Name: </td>
			<td><input type="text" name="userName"/></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Login"/></td>
		</tr>
	</table>
</form>
</body>
</html>