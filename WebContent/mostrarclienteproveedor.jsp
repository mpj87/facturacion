<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="p1" class="com.vipper.modelo.ClienteProveedor" scope="request" />
	<h1>Datos del cliente o proveedor</h1>
	<ul>
		<li>Id:<%=p1.getId() %></li>
		<li>Nif:<%=p1.getNif()%></li>
		<li>Nombre:<%=p1.getNombre()%></li>
		<li>Direccion:<%=p1.getDireccion() %></li>
		<li>Tipo:<%=p1.getTipo() %></li>
		<li>Email:<%=p1.getEmail() %></li>
		<li>Telefono:<%=p1.getTelefono() %></li>
	</ul>
</body>
</html>