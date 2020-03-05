<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("id")!=null){%>
<jsp:useBean id="p2" scope="request" class="com.vipper.modelo.ServiciosProductos"/>
<jsp:setProperty name="p2" property="*"/> <!-- Se utiliza * si es global y quieres que recoja todos los datos del formulario de abajo -->
<jsp:forward page="servletfacturacion?op=4"/>
<% }%>
<form action="mostrarunservicio.jsp" method="post">
Servicio : <input type="text" name="id"/>
<input type="submit" value="Buscar servicio"/>
</form>
</body>
</html>