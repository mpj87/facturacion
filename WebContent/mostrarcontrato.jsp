<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Datos Contrato</title>
</head>
<body>
	<jsp:useBean id="p9" class="com.vipper.modelo.Contrato"
		scope="request" />
	<h1>Datos del Contrato</h1>
	<ul>
		<li>IdContrato:<%=p9.getId_contrato()%></li>
		<li>Id:<%=p9.getId()%></li>
		<li>Comision:<%=p9.getComision()%></li>
		<li>EncargadoFacturacion :<%=p9.getEncargado_facturacion()%></li>
	</ul>
</body>
</html>