<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "Details.htm" method="post">
<h1 align = "center"> Welcome</h1>
<h3 align = "center" style = "color:red">${message}</h3>
<table align= "center" border="1">
<tr>
<th>Number</th>
<th>Name</th>
</tr>
<c:forEach var="emp" items="${list}">
<tr>
<td><c:out value="${ emp.getEno()}"></c:out></td>
<td><c:out value="${ emp.getEname()}"></c:out></td>
</tr>
</c:forEach>

</table>

<h3 align = "center"><a href = "Register.jsp">Register New Employee</a></h3>

<h4 align ="center">Enter the Details of the Employee<input type="text" name="eno"><input type="submit" value = "submit!"></h4>
</form>
</body>
</html>