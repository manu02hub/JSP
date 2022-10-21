<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.config.Conexion"%>
<%@page import="imf.garaje.models.Cliente"%>
<%@page import="imf.garaje.modelsDAO.ClienteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/navs/navAdmin.css" />
<link rel="stylesheet" text="text/css" href="resources/css/table.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css" href="resources/css/admin.css" />
<title>Clientes</title>
</head>
<body>

	<div class="row" class="cajaGrande">

		<%@include file="../includes/navAdmin.jsp"%>

		<div class="col-lg-9 col-md-9 col-sm-9 cajaGrande">

			<a href="ClienteController?action=create" type="button"
				class="btn btn-danger btn-sm"> Crear</a>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Foto</th>
						<th scope="col">Nombre</th>
						<th scope="col">Email</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">


					<daw:forEach var="cliente" items="${cli}">
						<tr>
							
						<th scope="row">${cliente.getId()}</th>
						<td>${cliente.getFoto()}</td>
						<td>${cliente.getNombre()}</td>
						<td>${cliente.getEmail()}</td>
							<td><a
							href="ClienteController?action=delete&id=${cliente.getId()}"
							type="button" id="eliminar" class="btn"> Eliminar</a> <a
							href="ClienteController?action=edit&id=${cliente.getId()}"
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