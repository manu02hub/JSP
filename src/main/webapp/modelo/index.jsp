<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.models.Modelo"%>
<%@page import="imf.garaje.modelsDAO.ModeloDAO"%>
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
<title>Tabla Modelo</title>
</head>
<body>

	<div class="row">

		<div class="col-lg-12 col-md-12 col-sm-12">
			<!--  PARA AÑADIR EL MENU ADMIN-->
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
						<th scope="col">Año</th>
						<th scope="col">Acciones</th>
						<th><a href="ModeloController?action=create" type="button"
							class="btn" id="crear"> Crear</a></th>
					</tr>
				</thead>

				<!-- ETIQUETA QUE RECORRE LOS DATOS DE MODELOS RECIBIDOS -->
				<tbody class="table-group-divider">
					<daw:forEach var="modelo" items="${mode}">
						<tr>

							<th scope="row">${modelo.getId_modelo()}</th>
							<td><img src="${modelo.getFoto_modelo()}" width="auto"
								height="80px"></td>
							<td>${modelo.getNombre_modelo()}</td>
							<td>${modelo.getAnno()}</td>
							<td><a
								href="ModeloController?action=delete&id=${modelo.getId_modelo()}"
								type="button" id="eliminar" class="btn"> Eliminar</a> <a
								href="ModeloController?action=edit&id=${modelo.getId_modelo()}"
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