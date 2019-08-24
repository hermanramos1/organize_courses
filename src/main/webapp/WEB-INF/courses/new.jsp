<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a course</title>
</head>
<body>

	<h1>Add a new course</h1>

 <p><form:errors path="courseObj.*"/></p>
    
    <form:form method="POST" action="/courses" modelAttribute="courseObj">
       	<p>
            <form:label path="name">Name:</form:label>
            <form:input type="name" path="name"/>
        </p>
        <p>
            <form:label path="instructor">Instructor:</form:label>
            <form:input type="instructor" path="instructor"/>
        </p>
        <p>
            <form:label path="capacity">Capacity:</form:label>
            <form:input type="capacity" path="capacity"/>
        </p>
	

        <input type="submit" value="Add!"/>
    </form:form>

</body>
</html>