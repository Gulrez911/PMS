<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
		isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
		<div align="center">
		<a href="addProject">Project</a> &nbsp&nbsp&nbsp<a href="addEmployee">Add Employee</a>
				<table>
						<form:form action="assignSuccess" method="post" modelAttribute="task">
								<tr>
										<td><form:hidden path="projectId" />
												<form:hidden path="id" /></td>
								</tr>
								<tr>
										<td>Task Name:</td>
										<td><form:input path="taskName" readonly="true" /></td>
								</tr>
								<tr>
										<td>Description:</td>
										<td><form:input path="taskDescription" readonly="true" /></td>
								</tr>
								<tr>
										<td>Start Date:</td>
										<td><form:input path="startDate" type="date" readonly="true" /></td>
								</tr>
								<tr>
										<td>End Date:</td>
										<td><form:input path="endDate" type="date" readonly="true" /></td>
								</tr>
								<tr>
										<td>Select Employee:</td>
										<td><form:select path="empEmail" items="${empList}" /></td>
								</tr>

								<tr>
										<td><input type="submit" value="Assign Task" /></td>
								</tr>
						</form:form>
				</table>

		</div>
</body>
</html>