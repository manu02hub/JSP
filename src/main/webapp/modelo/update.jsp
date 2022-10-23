<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.models.Modelo"%>
<%@page import="imf.garaje.modelsDAO.ModeloDAO"%>
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
<title>Actualizar Modelo</title>
</head>
<body>


	<!-- RECOJO DATO DEL MODELO SELECCIONADO -->
	<%
	Modelo modelo = (Modelo) request.getAttribute("mod");
	%>

	<div class="row">

		<div class="col-lg-12 col-md-12 col-sm-12">
			<!--  PARA AÑADIR EL MENU ADMIN-->
			<%@include file="../includes/navAdm.jsp"%>

		</div>
	</div>

	<!-- FORM UPDATE-->
	<div class=row>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
		<div class="col-lg-6 col-md-6 col-sm-6 form-register"
			id="contenedorForm">


			<form method="POST" action="ModeloController?action=update">
				<h4>FORMULARIO ACTUALIZAR MODELO</h4>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<img src="<%=modelo.getFoto_modelo()%>" height="auto"
							width="250px" id="perfil">
					</div>

					<div class="col-lg-12 col-md-12 col-sm-12">

						<input type="hidden" name="id" value="<%=modelo.getId_modelo()%>">
						<p>Nombre:</p>
						<input type="text" name="nombre_modelo" class="controls"
							value="<%=modelo.getNombre_modelo()%>"> <br>
						<p>Año:</p>
						<input type="text" class="controls" name="anno"
							value="<%=modelo.getAnno()%>">
						<p>Cambiar foto:</p>
						<input type="file" class="controls" name="foto_modelo"
							value="<%=modelo.getFoto_modelo()%>">

					</div>

					<div class="col-lg-12 col-md-12 col-sm-12">
						<button type="submit" class="botons">Actualizar</button>
					</div>


				</div>
			</form>

		</div>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
	</div>

</body>
</html>