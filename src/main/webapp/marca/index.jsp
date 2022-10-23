<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.models.Marca"%>
<%@page import="imf.garaje.modelsDAO.MarcaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw"%>
<%@ include file = "../login/login-validation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css" href="resources/css/table.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Tabla Marca</title>
</head>
<body>

	<div class="row">

		<div class="col-lg-12 col-md-12 col-sm-12">
			<!--  PARA A�ADIR EL MENU ADMIN-->
			<%@include file="../includes/navAdm.jsp"%>

		</div>

		<div class="col-lg-2"></div>

		<div class="col-lg-8 col-md-12 col-sm-12" id="contenedorTabla">


			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Foto</th>
						<th scope="col">Nombre</th>
						<th scope="col">Acciones</th>
						<th><a href="MarcaController?action=create" type="button"
							class="btn" id="crear"> Crear</a></th>
					</tr>
				</thead>
				<tbody class="table-group-divider">

					<!-- ETIQUETA QUE RECORRE LOS DATOS DE MARCAS RECIBIDOS -->
					<daw:forEach var="marca" items="${mar}">
						<tr>

							<th scope="row">${marca.getId_marca()}</th>
							<td><img src="${marca.getFoto_marca()}" width="auto"
								height="80px"></td>
							<td>${marca.getNombre_marca()}</td>
							<td><a
								href="MarcaController?action=delete&id=${marca.getId_marca()}"
								type="button" id="eliminar" class="btn"> Eliminar</a> <a
								href="MarcaController?action=edit&id=${marca.getId_marca()}"
								type="button" id="modificar" class="btn"> Modificar</a></td>
						</tr>
					</daw:forEach>
				</tbody>
			</table>

		</div>
		<div class="col-lg-2"></div>
	</div>

</body>
</html>