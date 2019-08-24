<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Course</title>
</head>
<body>

	<h1>${course.name}</h1>
	<p>Instructor: ${course.instructor}</p>
	<p>Sign Ups: ${studentNum}</p>
	
	<table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Sign Up Date</th>
	        </tr>
	    </thead>
	    <tbody>
       		<c:forEach items="${allStudents}" var="student">
	        <tr>
	            <td><c:out value="${student.name}"/></td>
	            <td><c:out value="${student.getCreatedAt()}"/></td>

		
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	<a href="/courses/${course.id}/edit">Edit</a>
	<a href="/courses/${course.id}/delete">Delete</a>
	
</body>
</html>