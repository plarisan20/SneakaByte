<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!-- Tag for JSP files -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Shoe Listing</title>
</head>
<body>
	<!-- EDITING SHOE LISTING -->
	<div>
		<form:form action="/itemlisting/edit/${thisShoe.id }" method="POST" modelAttribute="thisShoeListing">
			<!--  this is needed in order to use PutMapping -->
			<input type="hidden" name="_method" value="PUT"/>			

			<!-- Left article of the div -->
			<div>
				<h3>Create Listing</h3>
				
				<!-- Create an image to upload to the page -->
				
			
			</div>
			<!-- End of the left article -->
			
			
			<!-- Right article of the div -->
			<div>
				<div>
			        <form:label path="name">Name:</form:label>
			        <form:errors path="name"></form:errors>
			        <form:input path="name"/>
			    </div>
			    
			    <div>
			        <form:label path="price">Price:</form:label>
			        <form:errors path="price"></form:errors>
			        <form:input path="price"/>
			    </div>
			    
			    <div>
			        <form:label path="retailprice">Retail Price:</form:label>
			        <form:errors path="retailprice"></form:errors>
			        <form:input path="retailprice"/>
			    </div>
			    
			    <div>
			        <form:label path="releaseyear">Release Year:</form:label>
			        <form:errors path="releaseyear"></form:errors>
			        <form:input path="releaseyear"/>
			    </div>
			    
			    <div>
			        <form:label path="color">Color:</form:label>
			        <form:errors path="color"></form:errors>
			        <form:input path="color"/>
			    </div>
			    	
			    <div>
			        <form:label path="description">Condition:</form:label>
			        <form:errors path="description"></form:errors>
			        <form:input path="description"/>
			    </div>
			    
			    
	<!-- this is needed in order to know in the form that this is the user that is log in and passing the form -->		
				<form:input type="hidden" path="shoeCreator" value="${loggedUser.id}"/>
				
			<!-- After Submitting, this would go straight to, viewforsaleshoes.jsp -->
				<input type="submit" value="Edit Listing">
			</div>
			<!-- End of the right article -->
		</form:form>
		
			<a href="/itemlisting/account/${thisShoe.id}">Cancel</a>
	</div>
</body>
</html>