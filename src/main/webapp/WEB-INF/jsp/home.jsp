<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/core/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/core/jquery.autocomplete.min.js" />"></script>
<link href="<c:url value="/resources/core/main.css" />" rel="stylesheet">
<title>ChitMonks</title>
</head>
<body>
	<div align="right">
		<input type="text" id="w-input-search" value=""> <span>
			<button id="w-button-search" type="button">Search</button>
		</span>
	</div>
	<div align="center">
		<h1>Employee List</h1>

		<table border="1">

			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>

					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td>${employee.telephone}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Employee Register <a href="newEmployee">here</a>
		</h4>
	</div>
	<script>
		$(document)
				.ready(
						function() {

							$('#w-input-search')
									.autocomplete(
											{
												serviceUrl : '${pageContext.request.contextPath}/getTags',
												paramName : "tagName",
												delimiter : ",",
												transformResult : function(
														response) {

													return {

														suggestions : $
																.map(
																		$
																				.parseJSON(response),
																		function(
																				item) {

																			return {
																				value : item.tagName,
																				data : item.id
																			};
																		})

													};

												}

											});

						});
	</script>
</body>
</html>