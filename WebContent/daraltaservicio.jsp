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
<jsp:useBean id="p3" scope="request" class="com.vipper.modelo.ServiciosProductos"/>
<jsp:setProperty name="p3" property="*"/>
<jsp:forward page="servletfacturacion?op=5"/>
<% }%>
<form action="daraltaservicio.jsp" method="post">
Descripción : <input type="text" name="descripcion"/>
Coste : <input type="text" name="coste"/>
id : <input type="text" name="id"/>
iva : <input type="text" name="iva"/>
<input type="submit" value="Dar alta Servicio"/>
</form>
</body>
</html>