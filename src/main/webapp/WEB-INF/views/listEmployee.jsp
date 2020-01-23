<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div align="center">

				<table border="1px">
						<tr>
								<th>Name</th>
								<th>Email</th>
								<th>State</th>
								<th>Mobile</th>
								<th>User Type</th>
						<tr>

								<c:forEach items="${listuser}" var="user">
										<tr>
												<td>${user.firstName}${user.lastName}</td>
												<td>${user.email}</td>
												<td>${user.state}</td>
												<td>${user.mobile}</td>
												<td>${user.userType}</td>
										</tr>
								</c:forEach>
				</table>
		</div>
</body>
</html>