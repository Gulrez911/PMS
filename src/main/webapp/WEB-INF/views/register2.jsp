<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
		isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
		<div align="center">
				<table>
						<form:form action="saveEmployee" method="post" modelAttribute="user">

								<tr>
										<td>First Name:</td>
										<td><form:input path="firstName" /></td>
								</tr>
								<tr>
										<td>Last Name:</td>
										<td><form:input path="lastName" /></td>
								</tr>
								<tr>
										<td>Email:</td>
										<td><form:input path="email" /></td>
								</tr>
								<tr>
										<td>State:</td>
										<td><form:input path="state" /></td>
								</tr>
								<tr>
										<td>Mobile:</td>
										<td><form:input path="mobile" /></td>
								</tr>

								<tr>
										<td><input type="submit" value="Register" /></td>
								</tr>
						</form:form>
				</table>
				${msg}
		</div>
</body>
</html>