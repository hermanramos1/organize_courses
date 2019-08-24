<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>    
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body> 
	<h1>Edit Course</h1>
<form:form action="/courses/${course.id}" method="post" modelAttribute="course">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="instructor">Instructor:</form:label>
        <form:errors path="instructor"/>
        <form:textarea path="instructor"/>
    </p>
    <p>
        <form:label path="capacity">Capacity:</form:label>
        <form:errors path="capacity"/>
        <form:input path="capacity"/>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>