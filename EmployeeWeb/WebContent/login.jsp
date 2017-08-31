<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "Login.htm" method="post">
<h1 align = "center"> Welcome</h1>
<h3 align = "center">Please enter login Credentials</h3>
<h3 align = "center" style = "color:red">${message}</h3>
<table align= "center" >
<tr>
<th>User Id</th>
<th><input type="text" name = "username"></th>
</tr>
<tr>
<th>Password</th>
<th><input type = "password" name = "password"></th>
</tr>
<tr>
<th>
<input type="reset" value="clear"></th>
<th><input type="submit" value = "submit"></th></tr>
</table>
</form>
</body>
</html>