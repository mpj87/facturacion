<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Contrato</title>
</head>
<body>
<%if(request.getParameter("id")!=null){%>
<jsp:useBean id="p10" scope="request" class="com.vipper.modelo.Contrato"/>
<jsp:setProperty name="p10" property="*"/>
<jsp:forward page="servletfacturacion?op=11"/>
<% }%>
<form action="daraltacontrato.jsp" method="post">
idContrato : <input type="text" name="id_contrato"/>
<br/> 
id : <input type="text" name="id"/>
<br/> 
Comision : <input type="text" name="comision"/>
<br/> 
Encargado_facturacion : <input type="text" name="encargado_facturacion"/>
<br/> 
<input type="submit" value="Dar de alta Contrato"/>
</form>
</body>
</html>