<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.models.Marca"%>
<%@page import="imf.garaje.modelsDAO.MarcaDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css" href="resources/css/form.css" />
<title>Actualizar Marca</title>
</head>
<body>

	<h1>MARCA EDIT</h1>
	<%
	Marca marca = (Marca) request.getAttribute("mar");
	%>

	<div class=row>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
		<div class="col-lg-6 col-md-6 col-sm-6 form-register"
			id="contenedorForm">

			<form method="POST" action="MarcaController?action=update">

				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-4">
						<img src="http://localhost/img/DWES/p1/bmw.jpg" height="100px"
							width="100px" id="perfil">
					</div>

					<div class="col-lg-8 col-md-8 col-sm-8">
						<input type="hidden" class="controls" name="id"
							value="<%=marca.getId_marca()%>">
						<p>Nombre:</p>
						<input type="text" class="controls" name="nombre_marca"
							value="<%=marca.getNombre_marca()%>">
						<button class="botons" type="submit">Actualizar</button>
					</div>
				</div>

			</form>

		</div>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
	</div>

</body>
</html>