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
<jsp:useBean id="p7" scope="request" class="com.vipper.modelo.ClienteProveedor"/>
<jsp:setProperty name="p7" property="*"/>
<jsp:forward page="servletfacturacion?op=8"/>
<% }%>
<form action="daraltaclienteproveedor.jsp" method="post">
id : <input type="text" name="id"/>
<br/> 
nif : <input type="text" name="nif"/>
<br/> 
nombre : <input type="text" name="nombre"/>
<br/> 
Direccion : <input type="text" name="direccion"/>
<br/> 
Tipo : <input type="text" name="tipo"/>
<br/> 
Email : <input type="text" name="email"/>
<br/> 
Telefono : <input type="text" name="telefono"/>
<br/> 
<input type="submit" value="Dar alta Cliente o Proveedor"/>
</form>
</body>
</html>