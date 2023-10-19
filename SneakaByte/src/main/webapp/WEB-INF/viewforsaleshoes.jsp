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
<title>Buy Shoes</title>
</head>
<body>
	<div>
		<div>
			<!-- Header -->
			<h2>View shoe options for sale</h2>
			<!-- Add something if you wnat to add later on -->
		</div>
	<hr>
		<div>
			<!-- Left Article -->
			<div>
				<h3><c:out value="${ thisShoe.name}"/></h3>
				<p>$<c:out value="${ thisShoe.price }"/></p>
				
				
				<!-- Need to add the picture later on -->
			</div>
			<!-- End of left article -->
			
			
			<!-- Right Article -->
			<div>
				<p>Color: <c:out value="${ thisShoe.color}"/></p>
				<p>Retail Price: <c:out value="${ thisShoe.retailprice}"/></p>
				<p>Condition: <c:out value="${ thisShoe.description}"/></p>
				<p>Release Year: <c:out value="${ thisShoe.releaseyear}"/></p>
				
				<!-- Add to cart option later on -->
				
				<!-- this is for the name of the Account User -->
				<p>Seller: <c:out value="${loggedUser.userName}"/> </p>
			</div>
			<!-- End of right article -->
			
			<hr>
			
			<!-- Only the user that created this could see this method -->
			<c:if test="${loggedUser.id == thisShoe.shoeCreator.id }" >
				<div>
				<!-- EDIT -->
					<div>
						<a href="/itemlisting/edit/${thisShoe.id}">Edit</a>
					</div>
					<div>
						<a href="/homepage">Cancel</a>
					</div>
					
				<!-- DELETE METHOD -->
					<div>
						<form method="post" action="/delete/${thisShoe.id}">
							<!-- set it up like this in order for delete button to work 
							<input type="hidden" name="_method" value="delete"/>
							 -->
							 <div>
								<input type="hidden" name="_method" value="delete"/>
								<input type="submit" value="Delete"/>
							 </div>
			
						</form>
					</div>
				
				</div>
			</c:if>
				
			
			
		</div>
	
	</div>
</body>
</html>