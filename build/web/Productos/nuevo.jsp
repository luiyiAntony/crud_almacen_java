<%-- 
    Document   : nuevo
    Created on : Jan 24, 2024, 4:46:36 PM
    Author     : blablabla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h2>Nuevo registro</h2>
		<form action="ProductosController?accion=insertar" method="POST" autocomplete="off">
			<p>codigo: 
				<input id="codigo" name="codigo" type="text" />
			</p>
			<p>nombre: 
				<input id="nombre" name="nombre" type="text" />
			</p>
			<p>precio: 
				<input id="precio" name="precio" type="text" />
			</p>
			<p>existencia: 
				<input id="existencia" name="existencia" type="text" />
			</p>

			<button id="guardar" name="guardar" type="submit">Guardar</button>

		</form>
	</body>
</html>
