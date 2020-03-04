<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="p6" class="com.vipper.modelo.ClienteProveedor" scope="request" />
	<h1>Datos del cliente o proveedor</h1>
	<ul>
		<li>Id:<%=p6.getId() %></li>
		<li>Nif:<%=p6.getNif()%></li>
		<li>Nombre:<%=p6.getNombre()%></li>
		<li>Direccion:<%=p6.getDireccion() %></li>
		<li>Tipo:<%=p6.getTipo() %></li>
		<li>Email:<%=p6.getEmail() %></li>
		<li>Telefono:<%=p6.getTelefono() %></li>
	</ul>
</body>
</html>