<%-- 
    Document   : index
    Created on : Jan 24, 2024, 4:45:42 PM
    Author     : blablabla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Almacen</title>
        </head>
        <body>
                <h1>Productos</h1>
		<a href="ProductosController?accion=nuevo">Nuevo registro</a>
		<br/><br/>
		<table border="1" width="80%">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Existencia</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="producto" items="${lista}">
					<tr>
						<td><c:out value="${producto.codigo}"/></td>
						<td><c:out value="${producto.nombre}"/></td>
						<td><c:out value="${producto.precio}"/></td>
						<td><c:out value="${producto.existencia}"/></td>
						<td><a href="ProductosController?accion=modificar&id=<c:out value="${producto.id}"/>">modificar</a></td>
						<td><a href="ProductosController?accion=eliminar&id=<c:out value="${producto.id}"/>">eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
        </body>
</html>











