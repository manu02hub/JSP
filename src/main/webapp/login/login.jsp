<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<!-- LLAMA A LA FUNCION OCULTAR DEL JS -->
<body onload="Ocultar()">

	<div class="popup">
		<div class="close-btn">&times;</div>
		<div class="row" id="contenedorBotones">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="form-element">
					<button class="btnUsu" onclick="login()">Sign in</button>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="form-element">
					<button class="btnUsu" onclick="registro()">Registro</button>
				</div>
			</div>

		</div>

		<!-- FORM LOGIN -->
		<form class="form" id="showLogin" method="POST"
			action="AuthController?action=login">
			<div class="form-element">
				<label for="email">Email</label> <input type="text" id="email"
					name="email" placeholder="Enter email">
			</div>
			<div class="form-element">
				<label for="password">Password</label> <input type="password"
					name="password" id="password" placeholder="Enter password">
			</div>

			<div class="form-element">
				<button>Sign in</button>
			</div>

		</form>

		<!-- FORM REGISTRO -->
		<form class="form" id="showRegsitro" method="POST"
			action="UsuarioController?action=create">

			<div class="form-element">
				<label for="nombre">Nombre</label> <input type="text" id="nombre"
					name="nombre" placeholder="Nombre Apellidos">
			</div>
			<div class="form-element">
				<label for="dni">DNI</label> <input type="text" id="dni" name="dni"
					placeholder="12345678X">
			</div>
			<div class="form-element">
				<label for="email">Email</label> <input type="text" id="email2"
					name="email" placeholder="Enter email">
			</div>
			<div class="form-element">
				<label for="password">Password</label> <input type="password"
					name="password" id="password2" placeholder="Enter password">
			</div>

			<div class="form-element">
				<button>Registro</button>
			</div>

		</form>


	</div>
</body>
</html>