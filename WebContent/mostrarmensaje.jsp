<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if((boolean)session.getAttribute("altaC")){
	%>
	<h1>Su petici�n se ha realizado con �xito</h1>
<% }else{%>
	<h1>Su petici�n no se ha podidio realizar </h1>
<%} %>
</body>
</html>