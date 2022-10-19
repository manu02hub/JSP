<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css" href="resources/css/form.css" />
<title>CrearUsuario</title>
</head>
<body>

	<div class=row>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
		<div class="col-lg-6 col-md-6 col-sm-6 form-register"
			id="contenedorForm">
			<form method="POST" action="ClienteController?action=create">
			<h4>FORMULARIO AÑADIR CLIENTE</h4>
				<input type="hidden" name="id"> <input type="text"
					id="fname" class="controls" name="nombre"
					placeholder="Nombre Cliente"> <input type="email"
					id="email" class="controls" name="email" placeholder="@gamil.com">

				<input type="file" id="foto_cliente"
					class="controls" name="fotocliente"> <a href="#"
					type="button" class="btn"> Volver</a> <input type="submit"
					value="Insertar" class="botons">
			</form>
		</div>

		<div class="col-lg-3 col-md-3 col-sm-3"></div>
	</div>
</body>
</html>