<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="imf.garaje.models.Cliente"%>
<%@page import="imf.garaje.modelsDAO.ClienteDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css" href="resources/css/form.css" />
<title>Modificar Usuario</title>
</head>
<body>
	<h1>USUARIOS EDIT</h1>
	<%
	Cliente cliente = (Cliente) request.getAttribute("cli");
	%>

	<div class=row>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
		<div class="col-lg-6 col-md-6 col-sm-6 form-register"
			id="contenedorForm">

			<form method="POST" action="ClienteController?action=update">

				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-4">
						<img src="http://localhost/img/DWES/p1/perfil.jpg" height="120px" width="auto" id="perfil">
					</div>
					
					<div class="col-lg-8 col-md-8 col-sm-8">
						<input type="hidden" name="id" value="<%=cliente.getId()%>">
						<p>Nombre:</p>
						<input type="text" name="nombre" class="controls"
							value="<%=cliente.getNombre()%>">
						<p>Email:</p>
						<input type="email" name="email" class="controls"
							value="<%=cliente.getEmail()%>">
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<button class="botons" type="submit">Actualizar</button>
					</div>
				</div>

			</form>
		</div>

		<div class="col-lg-3 col-md-3 col-sm-3"></div>
	</div>


</body>
</html>