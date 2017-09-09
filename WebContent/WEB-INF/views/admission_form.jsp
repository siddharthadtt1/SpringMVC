<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission Form</title>
</head>
<body>
	<h2>${headerMsg }</h2>

	<h4 style="color: red"><form:errors path="student1.*" /></h4>

	<form action="/Spring_MVC/admissionRequest" method="post">
		<table>
			<tr>
				<td><label for="nameId">Name : </label><input type="text"
					name="name" id="nameId" /></td>
			</tr>
			<tr>
				<td><label for="ageId">Age : </label><input type="text"
					name="age" id="ageId" /></td>
			</tr>
			<tr>
				<td><label for="submissionDateId">Date : </label><input
					type="text" name="submissionDate" id="submissionDateId" /></td>
			</tr>
			<tr>
				<td><label for="skillId">Skills : </label><select name="skills"
					id="skillId" multiple="true">
						<option>Spring</option>
						<option>Hibernate</option>
						<option>Angular JS</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="countryId">Country :</label><input type="text" name="address.country" id="countryId" /></td>
				<td><label for="cityId">City :</label><input type="text" name="address.city" id="cityId" /></td>
				<td><label for="streetNoId">Street No :</label><input type="text" name="address.streetNo" id="streetNoId" /></td>
				<td><label for="pincodeId">Pincode :</label><input type="text" name="address.pincode" id="pincodeId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Apply" /></td>
			</tr>
		</table>
	</form>

</body>
</html>