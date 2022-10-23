<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.config.Conexion"%>
<%@page import="imf.garaje.models.Usuario"%>
<%@page import="imf.garaje.modelsDAO.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
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
<title>Clientes</title>
</head>
<body>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	Usuario u = (Usuario) request.getSession().getAttribute("usuario");
	%>

	<div class="row">

		<div class="col-lg-12 col-md-12 col-sm-12">
			<!--  PARA AÑADIR EL MENU ADMIN-->
			<%@include file="../includes/navAdm.jsp"%>

		</div>
	</div>

	<div class=row>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
		<div class="col-lg-6 col-md-6 col-sm-6 form-register"
			id="contenedorForm">

			<form method="POST" action="UsuarioController?action=update">
				<h4>MI PEFIL</h4>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12" id="miperfil">
						<img src="<%=u.getImage()%>" height="80%" width="70%" id="perfil">
					</div>

					<div class="col-lg-12 col-md-12 col-sm-12">
						<input type="hidden" name="id" value="<%=u.getId()%>">
						<p>Nombre:</p>
						<input type="text" name="nombre" class="controls"
							value="<%=u.getNombre()%>">
						<p>Email:</p>
						<input type="email" name="email" class="controls"
							value="<%=u.getEmail()%>">
						<p>Nueva Contraseña:</p>
						<input type="password" name="password" class="controls">
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<a href="UsuarioController?action=delete&id=<%=u.getId()%>"
							type="submit" id="eliminar" class="btn"> Eliminar</a>
						<button type="submit" id="modificar" class="btn">
							Modificar</button>
					</div>
				</div>

			</form>
		</div>

		<div class="col-lg-3 col-md-3 col-sm-3"></div>
	</div>
</body>

</html>