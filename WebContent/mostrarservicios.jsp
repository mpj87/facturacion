<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p2" class="com.vipper.modelo.ServiciosProductos"
		scope="request" />
	<h1>Datos del Servicio</h1>
	<ul>
		<li>Id:<%=p2.getId_servicio()%></li>
		<li>Descripcion:<%=p2.getDescripcion()%></li>
		<li>Coste:<%=p2.getCoste()%></li>
		<li>Id Cliente:<%=p2.getId()%></li>
		<li>IVA:<%=p2.getIva()%></li>

	</ul>
</body>
</html>