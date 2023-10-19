<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Account</title>
</head>
<body>


			<h2>Log in</h2>
	<!-- modelAttribute must be the same name on the Controller -->
	
	<form:form action="/login" method="post" modelAttribute="loginUser">
	
		<div>
			<form:label path="email"> Email: </form:label>
			<form:errors path="email"/>
			<form:input type="email" path="email"/>
		</div>
		<div>
			<form:label path="password"> Password: </form:label>
			<form:errors path="password"/>
			<form:password path="password"/>
		</div>
		
		<input type="submit" value="Log In"/>
	
	</form:form>
	
	
</body>
</html>