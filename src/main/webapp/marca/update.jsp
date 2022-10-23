<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.models.Marca"%>
<%@page import="imf.garaje.modelsDAO.MarcaDAO"%>
<%@ include file="../login/login-validation.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css" href="resources/css/form.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Actualizar Marca</title>
</head>
<body>



	<!-- RECOJO DATO DE LA MARCA SELECCIONADO -->
	<%
	Marca marca = (Marca) request.getAttribute("mar");
	%>

	<div class="row">

		<div class="col-lg-12 col-md-12 col-sm-12">
			<!--  PARA AÑADIR EL MENU ADMIN-->
			<%@include file="../includes/navAdm.jsp"%>

		</div>
	</div>

	<!-- FORM UPDATE-->
	<div class=row>
		<div class="col-lg-3"></div>
		<div class="col-lg-6 col-md-12 col-sm-12 form-register"
			id="contenedorForm">

			<form method="POST" action="MarcaController?action=update">
				<h4>FORMULARIO ACTUALIZAR MARCA</h4>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-4">
						<img src="<%=marca.getFoto_marca()%>" height="auto" width="100px"
							id="perfil">
					</div>

					<div class="col-lg-8 col-md-8 col-sm-8">
						<input type="hidden" class="controls" name="id"
							value="<%=marca.getId_marca()%>">
						<p>Nombre:</p>
						<input type="text" class="controls" name="nombre_marca"
							value="<%=marca.getNombre_marca()%>">
						<p>Cambiar Foto:</p>
						<input type="file" name=foto class="controls"
							value="<%=marca.getFoto_marca()%>">
					</div>

					<div class="col-lg-12 col-md-12 col-sm-12">
						<button class="botons" type="submit">Actualizar</button>
					</div>
				</div>

			</form>

		</div>
		<div class="col-lg-3"></div>
	</div>

</body>
</html>