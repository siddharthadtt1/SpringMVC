<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission Success</title>
</head>
<body>

	<h2>${headerMsg}</h2>

	<h4>${student1.name} your application has been successfully
		submitted</h4>
		
	<h3>Please check your submitted values </h3>
	
	<table>
		<tr>
			<td>Name: </td>
			<td>${student1.name }</td>
		</tr>
		<tr>
			<td>Age: </td>
			<td>${student1.age }</td>
		</tr>
		<tr>
			<td>Date: </td>
			<td>${student1.submissionDate }</td>
		</tr>
		<tr>
			<td>Skills :</td>
			<td>${student1.skills }</td>
		</tr>
		<tr>
			<td>Address :</td>
			<td>StreetNo : ${student1.address.streetNo}, ${student1.address.city},${student1.address.pincode}, ${student1.address.country}</td>
		</tr>
	</table>
</body>
</html>