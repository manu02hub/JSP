<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.models.Marca"%>
<%@page import="imf.garaje.modelsDAO.MarcaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css"
	href="resources/css/button.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/navs/navAdmin.css" />
<link rel="stylesheet" text="text/css" href="resources/css/table.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css" href="resources/css/admin.css" />
<title>Tabla Marca</title>
</head>
<body>

	<div class="row">

		<%@include file="../includes/navAdmin.jsp" %>

		<div class="col-lg-9 col-md-9 col-sm-9">

			<a href="MarcaController?action=create" type="button"
				class="btn btn-danger btn-sm"> Crear</a>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Foto</th>
						<th scope="col">Nombre</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<daw:forEach var="marca" items="${mar}">
						<tr>
							
						<th scope="row">${marca.getId_marca()}</th>
						<td><img src="${marca.getFoto_marca()}" width="auto" height="80px"></td>
						<td>${marca.getNombre_marca()}</td>
							<td><a
							href="MarcaController?action=delete&id=${marca.getId_marca()}"
							type="button" id="eliminar" class="btn"> Eliminar</a> <a
							href="MarcaController?action=edit&id=${marca.getId_marca()}"
							type="button" id="modificar" class="btn"> Modificar</a>
							</td>
						</tr>
					</daw:forEach>
				</tbody>
			</table>

		</div>

	</div>

</body>
</html>