<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	// 1. Recoger elemento del select
	String vehiculo = request.getParameter("sport");

	// 2. Creo la Cookie --> (clave, valor)
	// Ver API JEE Cookie.
	Cookie cookie = new Cookie("vehiculo", vehiculo);

	// 3. Establecer la vida de la cookie.
	// Tener en cuenta que es en segundos
	//cookie.setMaxAge(60*60); // 1h
	cookie.setMaxAge(60); // 5seg

	// 4. Enviar la cookie
	response.addCookie(cookie);
	%>
	<div class="row">

		<div class="col-lg-12 col-md-12 col-sm-12">
			<img>
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<h2>Nuevos coches,</h2>
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<h3>nuevas experiencias</h3>
		</div>
		<div class="col-lg-12 col-md-12 col-sm-12">
			<p>El nuevo Mustang va m�s all� del rendimiento. Desde mejoras
				bajo el cap� hasta una optimizaci�n en la aerodin�mica, el Mustang
				est� dise�ado para ofrecer una conducci�n estimulante cada vez que
				te pones al volante, ya sea para dar una vuelta el fin de semana o
				durante un largo viaje en carretera. Aunque sabemos que la
				conducci�n es lo m�s importante, no es lo �nico que nos preocupa.
				Tanto el GT como el Mach 1 incorporan tecnolog�as para que est�s
				informado, conectado y no te falte el entretenimiento. Adem�s, su
				sistema de frenado de alto rendimiento, su dise�o ergon�mico y los
				materiales de primera calidad te garantizan una conducci�n c�moda y
				segura.</p>
			<p>CARACTER�STICAS</p>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3">
			<h3>TAPICER�A</h3>
			<h4>CONDUCTOR</h4>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3"">
			<h3>ASIENTOS</h3>
			<h4>TRANSPIRABLES</h4>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3">
			<h3>MAYOR CONTROL</h3>
			<h4>DEL CONDUCTOR</h4>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3">
			<h3>M�S</h3>
			<h4>GADGETS</h4>
		</div>
	</div>

	<div class="col-lg-12 col-md-12 col-sm-12">
		<h2>Nuestros dise�os</h2>
	</div>

	<div class="row">
		<div class="col-sm-4 col-md-4 col-lg-4" id="actualidad">
			<h2>FORD 2018</h2>
			<p>CON�ZCALAS AQU�</p>
		</div>
		<div class="col-sm-4 col-md-4 col-lg-4" id="seguridad">
			<h2>RUEDAS PERSONALIZADAS</h2>
			<p>SABER M�S</p>
		</div>
		<div class="col-sm-4 col-md-4 col-lg-4">
			<h2>MALETERO EXTENSIBLE</h2>
			<p>MEJORAR AQU�</p>
		</div>
	</div>

</body>
</html>