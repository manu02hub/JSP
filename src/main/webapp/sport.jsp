<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<link rel="stylesheet" text="text/css" href="resources/css/login.css" />
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css" href="resources/css/footer.css" />
<link rel="stylesheet" text="text/css" href="resources/css/estilo3.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/navs/navIndex.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Playfair+Display&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap"
	rel="stylesheet">
<script src="resources/js/jquery-3.6.0.min.js"></script>

<title>Insert title here</title>
</head>
<body>

	<%
	// 1. Recoger elemento del select
	String vehiculo = request.getParameter("sport");

	// 2. Creo la Cookie --> (clave, valor)
	// Ver API JEE Cookie.
	Cookie cookie = new Cookie("sport", vehiculo);

	// 3. Establecer la vida de la cookie.
	// Tener en cuenta que es en segundos
	//cookie.setMaxAge(60*60); // 1h
	cookie.setMaxAge(60); // 5seg

	// 4. Enviar la cookie
	response.addCookie(cookie);
	%>
	<%@include file="includes/navIndex.jsp"%>

	<div class="row">
		<div class="col-sm-12 col-md-12 col-lg-12" id="part1"></div>
		<div class="col1 col-sm-12 col-md-12 col-lg-12">
			<h2>Nuevos coches,</h2>
		</div>
		<div class="col1 col-sm-12 col-md-12 col-lg-12">
			<h3>nuevas experiencias</h3>
		</div>
		<div class="col2 col-sm-12 col-md-12 col-lg-12">
			<p>El nuevo Mustang va mas alla del rendimiento. Desde mejoras
				bajo el capo hasta una optimizacion en la aerodinamica, el Mustang
				esta disenado para ofrecer una conducción estimulante cada vez que
				te pones al volante, ya sea para dar una vuelta el fin de semana o
				durante un largo viaje en carretera. Aunque sabemos que la
				conduccion es lo mas importante, no es lo unico que nos preocupa.
				Tanto el GT como el Mach 1 incorporan tecnologias para que estes
				informado, conectado y no te falte el entretenimiento. Ademas, su
				sistema de frenado de alto rendimiento, su diseno ergonomico y los
				materiales de primera calidad te garantizan una conduccion comoda y
				segura.</p>
			<p>CARACTERISTICAS</p>
		</div>
		<div class="colInterior col-sm-12 col-md-6 col-lg-3" id="img3">
			<h4>TAPICERIA CONDUCTOR</h4>
		</div>
		<div class="colInterior col-sm-12 col-md-6 col-lg-3" id="img4">
			<h4>ASIENTOS TRANSPIRABLES</h4>
		</div>
		<div class="colInterior col-sm-12 col-md-6 col-lg-3" id="img5">
			<h4>MAYOR CONTROL DEL CONDUCTOR</h4>
		</div>
		<div class="colInterior col-sm-12 col-md-6 col-lg-3" id="img6">
			<h4>MAS GADGETS</h4>
		</div>
	</div>

	<div class="col7 col-sm-12 col-md-12 col-lg-12">
		<h2>Nuestros disenos</h2>
	</div>

	<div class="row">
		<div class="colExterior col-sm-12 col-md-12 col-lg-4" id="exterior1">
			<h2>FORD 2018</h2>
			<p>CONOZCALAS AQUI</p>
		</div>
		<div class="colExterior col-sm-12 col-md-12 col-lg-4" id="exterior2">
			<h2>RUEDAS PERSONALIZADAS</h2>
			<p>SABER MAS</p>
		</div>
		<div class="colExterior col-sm-12 col-md-12 col-lg-4" id="exterior3">
			<h2>MALETERO EXTENSIBLE</h2>
			<p>MEJORAR AQUI</p>
		</div>
	</div>

</body>

<%@include file="includes/footer.jsp"%>
<script src="resources/js/modal.js"></script>
</html>