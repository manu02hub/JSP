<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.config.Conexion"%>
<%@page import="imf.garaje.models.Usuario"%>
<%@page import="imf.garaje.modelsDAO.UsuarioDAO"%>
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
<title>Clientes</title>
</head>
<body>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	Usuario usuario = (Usuario) request.getAttribute("usu");
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
						<input type="hidden" name="id" value="<%=usuario.getId()%>">
						<p>Nombre:</p>
						<input type="text" name="nombre" class="controls"
							value="<%=usuario.getNombre()%>">
						<p>Email:</p>
						<input type="email" name="email" class="controls"
							value="<%=usuario.getEmail()%>">
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<button class="botons" type="submit">Actualizar</button>
					</div>
				</div>

			</form>
		</div>

		<div class="col-lg-3 col-md-3 col-sm-3"></div>
	</div>

	<h1>HOLA ESTOY EN MI HOME</h1>
	<a href="UsuariosController?action=index">Index usuarios</a>
	<a href="AuthController?action=logout">Cerrar sesion</a>
</body>

</html>