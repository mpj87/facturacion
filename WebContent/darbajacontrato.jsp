<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("id_contrato")!=null){%>
<jsp:useBean id="p11" scope="request" class="com.vipper.modelo.Contrato"/>
<jsp:setProperty name="p11" property="*"/> <!-- Se utiliza * si es global y quieres que recoja todos los datos del formulario de abajo -->
<jsp:forward page="servletfacturacion?op=12"/>
<% }%>
<form action="darbajacontrato.jsp" method="post">
Contrato : <input type="text" name="id_contrato"/>
<input type="submit" value="Dar baja contrato"/>
</form>
</body>
</html>