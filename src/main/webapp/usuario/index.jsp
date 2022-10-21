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


	<%-- <h1>MARCA EDIT</h1>
	<%
	//Usuario usuario = (Usuario) request.getAttribute("usu");
	%>
	<div class=row><
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
		<div class="col-lg-6 col-md-6 col-sm-6 form-register"
			id="contenedorForm">


			<form method="POST" action="ModeloController?action=update">

				<div class="row">

					<div class="col-lg-12 col-md-12 col-sm-12">

						<p><%=//usuario.getNombre()%></p>

						<input type="hidden" name="id" value="<%=usuario.getId()%>">
						<p>Nombre:</p>
						<input type="text" name="nombre_modelo" class="controls"
							value="<%=//usuario.getNombre()%>"> <br>
					</div>
					
					<div class="col-lg-12 col-md-12 col-sm-12">

						<p>Mis reservas</p>

						<input type="hidden" name="id" value="<%=//usuario.getId()%>">
						<p>Nombre:</p>
						<input type="text" name="nombre_modelo" class="controls"
							value="<%=//usuario.getNombre()%>"> <br>
					</div>
				</div>
			</form>

		</div>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
	</div> --%>
	<h1>HOLA ESTOY EN MI HOME</h1>
	<a href="UsuariosController?action=index">Index usuarios</a>
	<a href="AuthController?action=logout">Cerrar sesion</a>
</body>

</html>