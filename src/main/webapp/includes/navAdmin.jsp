<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nav Admin</title>
</head>
<body>
	<div class="col-lg-3 col-md-3 col-sm-3 cajaGrande">
		<nav id="menu" class="left show">
			<ul>
				<li><a href="ClienteController?action=index" class="active"><i class="fa fa-home"></i>Clientes</a></li>
				<li><a href="MarcaController?action=index"><i class="fa fa-info-circle"></i>Marcas</a></li>
				<li><a href="ModeloController?action=index"><i class="fa fa-phone"></i>Modelos</a></li>
			</ul>
			<a href="#" id="showmenu"> <i class="fa fa-align-justify"></i>
			</a>
		</nav>
	</div>
</body>
</html>