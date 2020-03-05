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
<jsp:useBean id="p9" scope="request" class="com.vipper.modelo.Contrato"/>
<jsp:setProperty name="p9" property="*"/>
<jsp:forward page="servletfacturacion?op=10"/>
<% }%>
<form action="mostrarunocontrato.jsp" method="post">
Contrato : <input type="text" name="id"/>
<input type="submit" value="Buscar contrato"/>
</form>
</body>
</html>