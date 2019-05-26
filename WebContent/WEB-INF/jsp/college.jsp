<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
	
	    $("#id_gettime").click(function(){
	    	alert("hello");
	    });
   });
</script>
</head>
<body>

	<h1>College Admission Form</h1>
	<form:form modelAttribute="collegeForm">
		<table>
			<tr>
				<td colspan="2" style="color: red;"><form:errors path="*" /></td>
			</tr>

			<tr>
				<td>CollegeName :</td>
				<td><form:input path="collegeName" /></td>
			</tr>
			<tr>
				<td>University :</td>
				<td><form:input path="university" /></td>
			</tr>
			<tr>
				<td>Course :</td>
				<td><form:input path="course" /></td>
			</tr>
			<tr>
				<td>Fee :</td>
				<td><form:input path="fee" /></td>
			</tr>z
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
 <button id="id_gettime">Get server time</button>
 <p id="id_time"></p>
</body>
</html>