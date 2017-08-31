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
<h1 align = "center"> Welcome</h1>
<h3 align = "center">Details of the Employee</h3>
<table align= "center" border="1">
<c:forEach var="emp" items="${list}">
<tr>
<th>Number</th>
<th><c:out value="${ emp.getEno()}"></c:out></th>
</tr>
<tr>
<th>Name</th>
<th><c:out value="${ emp.getEname()}"></c:out></th>
</tr>
<tr>
<th>Gender</th>
<th><c:out value="${ emp.getGender()}"></c:out></th>
</tr>
<tr>
<th>Salary</th>
<th><c:out value="${ emp.getSalary()}"></c:out></th>
</tr>
<tr>
<th>UserId</th>
<th><c:out value="${ emp.getUsername()}"></c:out></th>
</tr>

</c:forEach>

</table>

<h3 align = "center"><a href = "ViewList.htm">Back to Home</a></h3>

</body>
</html>