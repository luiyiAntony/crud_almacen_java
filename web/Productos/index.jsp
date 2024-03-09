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
				<script type="text/javascript" src="snippet.js"></script>
                <title>Almacen</title>
        </head>
        <body>
                <h1>Productos</h1>
		<a href="ProductosController?accion=nuevo">Nuevo registro</a>
		<br>
		<label>Filter by Category</label>
		<select name="category" id="category" onchange="onChangeCategory(event)">
			<option value="all">All</option>
			<c:forEach var="category" items="${categories}">
				<option value="${category.category_id}">${category.category_name}</option>
			</c:forEach>
		</select>
		<label>Filter by price</label>
		<select name="range" id="range" onchange="onChangeRange(event)">
			<option value="all">All</option>
			<option value="less">Less than</option>
			<option value="greater">Greater than</option>
		</select>
		<input id="price" value="100" type="number" onchange="onChangePrice(event)"/>
		<button onclick="filterLauncher()">Filter</button>
		<br/><br/>
		<table border="1" width="80%">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Description</th>
					<th>Precio</th>
					<th>Units</th>
					<th>Category</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="producto" items="${productos}">
					<tr>
						${data}
						<td><c:out value="${producto.product_name}"/></td>
						<td><c:out value="${producto.product_description}"/></td>
						<td><c:out value="${producto.price}"/></td>
						<td><c:out value="${producto.units}"/></td>
						<td><c:out value="${producto.category_id}"/></td>
						<td><a href="ProductosController?accion=modificar&id=<c:out value="${producto.product_id}"/>">modificar</a></td>
						<td><a href="ProductosController?accion=eliminar&id=<c:out value="${producto.product_id}"/>">eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
        </body>
</html>











