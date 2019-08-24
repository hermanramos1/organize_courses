<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>
</head>
<body>

	<h1>Welcome, ${student.name}</h1>
	
	
	<h2>Courses</h2>

	<table>
	    <thead>
	        <tr>
	            <th>Course</th>
	            <th>Instructor</th>
	            <th>Capacity</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
       		<c:forEach items="${allCourses}" var="course">
	        <tr>
	            <td><a href="/courses/${course.id}"><c:out value="${course.name}"/></a></td>
	            <td><c:out value="${course.instructor}"/></td>
	            <td><c:out value="${course.capacity}"/></td>
	            <td><a href="/courses/${course.id}/add">Add</a></td>

	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<a href="/courses/new">Add a course</a>
	<br>
	<a href="/logout">Logout</a>
	
	
	
</body>
</html>