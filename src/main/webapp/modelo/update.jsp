<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="imf.garaje.models.Modelo"%>
<%@page import="imf.garaje.modelsDAO.ModeloDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css" href="resources/css/form.css" />
<title>Actualizar Modelo</title>
</head>
<body>

	<h1>MARCA EDIT</h1>
	<%
	Modelo modelo = (Modelo) request.getAttribute("mod");
	%>

	<div class=row>
		<div class="col-lg-3 col-md-3 col-sm-3"></div>
		<div class="col-lg-6 col-md-6 col-sm-6 form-register"
			id="contenedorForm">


			<form method="POST" action="ModeloController?action=update">

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