<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="login" method="POST">
	<table align="center" style="margin-top: 150px;">
		<tr>
			<td>User Name: </td>
			<td><input type="text" name="userName"/></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><input type="text" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Login"/></td>
		</tr>
	</table>
</form>
</body>
</html>