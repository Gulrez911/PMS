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
						<form:form action="saveTask" method="post" modelAttribute="task">
								<tr>
										<td><form:hidden path="projectId" /></td>
								</tr>
								<tr>
										<td>Task Name:</td>
										<td><form:input path="taskName" /></td>
								</tr>
								<tr>
										<td>Description:</td>
										<td><form:input path="taskDescription" /></td>
								</tr>
								<tr>
										<td>Start Date:</td>
										<td><form:input path="startDate" type="date" /></td>
								</tr>
								<tr>
										<td>End Date:</td>
										<td><form:input path="endDate" type="date" /></td>
								</tr>

								<tr>
										<td><input type="submit" value="Login" /></td>
								</tr>
						</form:form>
				</table>
				${msg}
				<table border="1px">
						<tr>
								<th>Task Name</th>
								<th>Task Description</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Action</th>
						</tr>
						<c:forEach items="${listTask}" var="list">
								<tr>
										<td>${list.taskName}</td>
										<td>${list.taskDescription}</td>
										<td>${list.startDate}</td>
										<td>${list.endDate}</td>
										<td><a href="assignTask?projectId=${list.projectId}&taskId=${list.id}">${list.action}</a></td>
								</tr>
						</c:forEach>
				</table>
		</div>
</body>
</html>