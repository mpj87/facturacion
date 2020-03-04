<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("id_servicio")!=null){%>
<jsp:useBean id="p4" scope="request" class="com.vipper.modelo.ServiciosProductos"/>
<jsp:setProperty name="p4" property="*"/> <!-- Se utiliza * si es global y quieres que recoja todos los datos del formulario de abajo -->
<jsp:forward page="servletfacturacion?op=6"/>
<% }%>
<form action="darbajaservicio.jsp" method="post">
Servicio : <input type="text" name="id_servicio"/>
<input type="submit" value="Dar baja servicio"/>
</form>
</body>
</html>