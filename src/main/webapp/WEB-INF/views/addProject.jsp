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
						<form:form action="saveProject" method="post" modelAttribute="project">

								<tr>
										<td>Project Name:</td>
										<td><form:input path="projectName" /></td>
								</tr>
								<tr>
										<td>Description:</td>
										<td><form:input path="projectDescription" /></td>
								</tr>
								<tr>
										<td>Start Date:</td>
										<td><form:input path="startDat" type="date" /></td>
								</tr>
								<tr>
										<td>End Date:</td>
										<td><form:input path="endDate" type="date" /></td>
								</tr>
								<tr>
										<td>Manager List:</td>
										<td><form:select path="endDate"  items="${userList}" itemLabel="email" itemValue="id"/></td>
								</tr>
								<tr>
										<td><input type="submit" value="Login" /></td>
								</tr>
						</form:form>
				</table>
				${msg}
				<table border="1px">
						<tr>
								<th>Project Name</th>
								<th>Project Description</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Action</th>
						</tr>
						<c:forEach items="${listProject}" var="list">
								<tr>
										<td>${list.projectName}</td>
										<td>${list.projectDescription}</td>
										<td>${list.startDat}</td>
										<td>${list.endDate}</td>
										<td><a href="addTask?projectId=${list.id}">Add Task</a></td>
								</tr>
						</c:forEach>
				</table>
		</div>
</body>
</html>