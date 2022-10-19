<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.models.Modelo"%>
<%@page import="imf.garaje.modelsDAO.ModeloDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
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
<title>Tabla Modelo</title>
</head>
<body>

	<div class="row">

		<%@include file="../includes/navAdmin.jsp"%>

		<div class="col-lg-9 col-md-9 col-sm-9">

			<a href="ModeloController?action=create" type="button"
				class="btn btn-danger btn-sm"> Crear</a>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Foto</th>
						<th scope="col">Nombre</th>
						<th scope="col">Año</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<%
					Modelo modelo = new Modelo();
					ArrayList<Modelo> listadoModelos = (ArrayList<Modelo>) request.getAttribute("mod");

					for (int i = 0; i < listadoModelos.size(); i++) {
						modelo = listadoModelos.get(i);
					%>

					<tr>

						<th scope="row"><%=modelo.getId_modelo()%></th>
						<td><%=modelo.getFoto_modelo()%></td>
						<td><%=modelo.getNombre_modelo()%></td>
						<td><%=modelo.getAnno()%></td>

						<td><a
							href="ModeloController?action=delete&id=<%=modelo.getId_modelo()%>"
							type="button" id="eliminar" class="btn""> Eliminar</a> <a
							href="ModeloController?action=edit&id=<%=modelo.getId_modelo()%>"
							type="button" id="modificar"  class="btn"> Modificar</a>
						</td>

					</tr>

					<%
					}
					%>
				</tbody>
			</table>

		</div>

	</div>


</body>
</html>