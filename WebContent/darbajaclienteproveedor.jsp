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
<jsp:useBean id="p8" scope="request" class="com.vipper.modelo.ClienteProveedor"/>
<jsp:setProperty name="p8" property="*"/> <!-- Se utiliza * si es global y quieres que recoja todos los datos del formulario de abajo -->
<jsp:forward page="servletfacturacion?op=9"/>
<% }%>
<form action="darbajaclienteproveedor.jsp" method="post">
ClienteProveedor : <input type="text" name="id"/>
<input type="submit" value="Dar baja cliente o proveedor"/>
</form>
</body>
</html>