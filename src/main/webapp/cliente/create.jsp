<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>CrearUsuario</title>
</head>
<body>

	<div class="row">

		<div class="col-lg-12 col-md-12 col-sm-12">
			<!--  PARA A?ADIR EL MENU ADMIN-->
			<%@include file="../includes/navAdm.jsp"%>

		</div>
	</div>

	<!-- FORM PARA CREAR CLIENTE -->
	<div class=row>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
		<div class="col-lg-6 col-md-6 col-sm-6 form-register"
			id="contenedorForm">
			<form method="POST" action="ClienteController?action=create">
				<h4>FORMULARIO A?ADIR CLIENTE</h4>
				<input type="hidden" name="id"> <input type="text"
					id="fname" class="controls" name="nombre"
					placeholder="Nombre Cliente"> <input type="email"
					id="email" class="controls" name="email" placeholder="@gamil.com">

				<input type="file" id="foto_cliente" class="controls"
					name="fotocliente"> <input type="submit" value="Insertar"
					class="botons">
			</form>
		</div>

		<div class="col-lg-3 col-md-3 col-sm-3"></div>
	</div>
</body>
</html>