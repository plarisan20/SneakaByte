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
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>User Registration</title>
</head>
<body>
 	<h2>Register</h2>
 	<!-- modelAttribute must be the same name on the Controller -->
	<form:form action="/register" method="post" modelAttribute="registerUser">
		<div>
			<form:label path="userName"> Username: </form:label>
			<form:errors path="userName"/>
			<form:input path="userName"/>
		</div>
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
		<div>
			<form:label path="confirmedPassword"> Confirm Password: </form:label>
			<form:errors path="confirmedPassword"/>
			<form:password path="confirmedPassword"/>
		</div>
		
		<input type="submit" value="Register"/>
	</form:form>

	


</body>
</html>