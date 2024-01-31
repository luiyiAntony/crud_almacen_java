<%-- 
    Document   : modificar
    Created on : Jan 24, 2024, 4:46:47 PM
    Author     : blablabla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h2>Modificar registro</h2>
		<form action="ProductosController?accion=actualizar" method="POST" autocomplete="off">

			<input id="id" name="id" type="hidden" value="<c:out value="${producto.id}"/>" />

			<p>codigo: 
				<input id="codigo" name="codigo" type="text" value="<c:out value="${producto.codigo}"/>" />
			</p>
			<p>nombre: 
				<input id="nombre" name="nombre" type="text" value="<c:out value="${producto.nombre}"/>"/>
			</p>
			<p>precio: 
				<input id="precio" name="precio" type="text" value="<c:out value="${producto.precio}"/>"/>
			</p>
			<p>existencia: 
				<input id="existencia" name="existencia" type="text" value="<c:out value="${producto.existencia}"/>"/>
			</p>

			<button id="guardar" name="guardar" type="submit">Guardar</button>

		</form>
	</body>
</html>
