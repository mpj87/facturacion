<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Usando beans:
1.clase encapsulada
2.Serializable(implementación de la interface)
3.Constructor vacio  -->
<%if(request.getParameter("id")!=null){%>
<jsp:useBean id="p6" scope="request" class="com.vipper.modelo.ClienteProveedor"/>
<jsp:setProperty name="p6" property="*"/>
<jsp:forward page="servletfacturacion?op=7"/>
<% }%>
<form action="mostrarunoCP.jsp" method="post">
ClienteProveedor : <input type="text" name="id"/>
<input type="submit" value="Buscar cliente o proveedor"/>
</form>
</body>
</html>