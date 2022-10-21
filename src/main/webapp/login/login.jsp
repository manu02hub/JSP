<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="Ocultar()">

	<div class="popup">
		<div class="close-btn">&times;</div>
		<div class="form-element">
			<button id="btnLogin" onclick="login()">Sign in</button>
		</div>
		<div class="form-element">
			<button id="btnRegsitro" onclick="registro()">Registro</button>
		</div>
		
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


		<form class="form" id="showRegsitro" method="POST"
			action="UsuarioController?action=create">

			<div class="form-element">
				<label for="nombre">Nombre</label> <input type="text" id="nombre"
					name="nombre" placeholder="Nombre Apellidos">
			</div>
			<div class="form-element">
				<label for="dni">DNI</label> <input type="text" id="dni"
					name="dni" placeholder="12345678X">
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