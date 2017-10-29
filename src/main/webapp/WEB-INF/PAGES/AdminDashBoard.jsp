<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin DashBoard</title>
</head>
<body>
	${message}
<br>
	<a href="getStudents">Show All Students</a>
	<br>
	<c:choose>
		<c:when test="${not empty students}">
			<table>
				<thead>
					<tr>Students List
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>STUDENT ID</td>
						<td>STUDENT NAME</td>
						<td>STUDENT MOBILE</td>
						<td>STUDENT CITY</td>
					</tr>

					<c:forEach items="${students}" var="student">
						<tr>
							<td><c:out value="${student.getStudentId()}"></c:out></td>
							<td><c:out value="${student.getStudentName()}"></c:out></td>
							<td><c:out value="${student.getStudentMobile()}"></c:out></td>
							<td><c:out value="${student.getStudentCity()}"></c:out></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<p>Results Not Found</p>
		</c:otherwise>
	</c:choose>


</body>
</html>