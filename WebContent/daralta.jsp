<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dar de alta producto</title>
</head>
<body>
	<form action="servletfacturacion?op=2" autocomplete="off" method="post">



		idPedido:<input type="text" name="id_pedido" /> 
		<br/> 
		Descripcion:<input type="text" name="descripcion" /> 
		<br/> 
		id: <input type="text" name="id" /> 
		<br/> 
		id_forma_pago <input type="text" name="id_forma_pago" />
		<br/> 
		total <input type="text" name="total" />
		<br/>  
		fecha <input type="text" name="fecha" />
		<br/>  
		id_servicio <input type="text" name="id_servicio" />
		<br/> 
		id_contrato <input type="text" name="id_contrato" />
		<br/> 
		importe_facturado <input type="text" name="importe_facturado" /> 
		<br/> 
		<input type="submit"> <input type="reset">

	</form>
</body>
</html>