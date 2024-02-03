<%-- 
    Document   : index
    Created on : Feb 1, 2024, 5:22:19 PM
    Author     : blablabla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Clientes</title>
	</head>
	<body>
		<h1>Clientes</h1>
		<a href="">Nuevo cliente</a>
		<br/><br/>
		<table border="1" width="80%">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nombre</th>
					<th>Username</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${lista}">
					<tr>
						<td><c:out value="${usuario.firstname}"/></td>
						<td><c:out value="${usuario.lastname}"/></td>
						<td><c:out value="${usuario.username}"/></td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
