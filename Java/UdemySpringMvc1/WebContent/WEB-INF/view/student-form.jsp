<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Student Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name : <form:input path="firstName"/>
		<br><br>
		Last name : <form:input path="lastName"/>
		<br><br>
		Country : 	
			<form:select path="country">
				<form:options items="${student.countryOptions}"/>		
<%-- 			<form:option value="Brazil" label="Brazil"></form:option>
				<form:option value="France" label="France"></form:option>
				<form:option value="Germany" label="Germany"></form:option>
				<form:option value="India" label="India"></form:option>
				<form:option value="Turkey" label="Turkey"></form:option> --%>
			</form:select>
		<br><br>
		Favorite Language : 
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			Python <form:radiobutton path="favoriteLanguage" value="Python"/>
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		<br><br>
		Operating Systems : 
			Linux <form:checkbox path="operatingSystems" value="Linux"/>
			Windows <form:checkbox path="operatingSystems" value="Windows"/>
			MacOs <form:checkbox path="operatingSystems" value="MacOs"/>
		<input type="submit" value="Submit"/>
		<br><br>
	</form:form>
</body>
</html>