<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<link rel="stylesheet" text="text/css" href="resources/css/login.css" />
<link rel="stylesheet" text="text/css" href="resources/css/footer.css" />
<link rel="stylesheet" text="text/css" href="resources/css/estilo.css" />
<link rel="stylesheet" text="text/css" href="resources/css/button.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/navs/navIndex.css" />
<script src="resources/js/jquery-3.6.0.min.js"></script>
<title>MANUS GARAGE</title>
</head>
<body>

	<!-- INCLUYE EL NAV -->
	<%@include file="includes/navIndex.jsp"%>

	<%
	//Lo que hago en esta parte es ver que cookie recibo y función de eso saco una imagen u otra
	String favorito = null;

	// 1. Leer la cookie del navegador
	Cookie[] cookies = request.getCookies();

	// 2. Buscamos la cookie con el nombre que queremos
	// En este caso el nombre es "deporte_favorito".
	if (cookies != null) {
		//out.print(cookies[cookies.length - 1].getName());

		if ("moto".equals(cookies[cookies.length - 1].getName())) {
	%>

	<div class="row" id="contImgFondoMoto"></div>
	<%
	} else if ("suv".equals(cookies[cookies.length - 1].getName())) {
	%>

	<div class="row" id="contImgFondoSuv"></div>
	<%
	} else if ("sport".equals(cookies[cookies.length - 1].getName())) {
	%>

	<div class="row" id="contImgFondoSport"></div>
	<%
	} else {
	%>

	<div class="row" id="contImgFondo">
		<div class="col-lg-12 col-md-12 col-sm-12" id="textIntro">
			<h2>ESPECIALISTAS EN WRAPPING & DETAILING</h2>
		</div>
	</div>
	<%
	}

	} else {
	%>
	<div class="row" id="contImgFondo">
		<div class="col-lg-12 col-md-12 col-sm-12" id="textIntro">
			<h2>ESPECIALISTAS EN WRAPPING & DETAILING</h2>
		</div>
	</div>
	<%
	}
	%>



	<!-- SECCION DEBAJO DE IMAGEn -->
	<div class="row">
		<div class="col-lg-4 col-md-12 col-sm-12" id="Snosotros">
			<h3>SOBRE NOSOTROS</h3>
			<p>Más de 10 años de experiencia en vinilado y detallado de
				vehículos. Desde cambiar el color completo o de alguna parte hasta
				conseguir dejar tu coche o moto como nuevo a través de limpiezas
				integrales, pulidos y tratamientos cerámicos. En Parson Garage nos
				adaptamos a tus necesidades para renovar, personalizar y cuidar tu
				vehículo con la garantía y experiencia que nos avala.</p>
		</div>
		<div class="col-lg-8 col-md-12 col-sm-12" id="trabajo">
			<div class="row" id="cosas">
				<div class="col-lg-4 col-md-12 col-sm-12 informacion">
					<h4>WRAPPING</h4>
					<p>Transforma el aspecto de tu vehículo con nuestro servicio de
						wrapping o vinilado. Más de 200 colores (satinados, brillos, mates
						y cromados) para personalizar partes o la totalidad de tu coche o
						moto y darle un aspecto exclusivo y duradero</p>
				</div>
				<div class="col-lg-4 col-md-12 col-sm-12 informacion">
					<h4>DETALING</h4>
					<p>Preserva y restaura la apariencia de tu vehículo con
						nuestros servicios de limpieza integral interior y exterior,
						pulido de carrocería y tratamientos cerámicos. Tu vehículo lucirá
						mejor que el primer día con resultados dignos de exposición</p>
				</div>
				<div class="col-lg-4 col-md-12 col-sm-12 informacion">
					<h4>PRO</h4>
					<p>Ofrecemos toda una gama de servicios profesionales de
						vinilado y rotulado de flotas, ediciones limitadas para
						concesionarios, limpieza integral, detallado y mantenimiento a
						domicilio etc.</p>
				</div>
			</div>
		</div>
	</div>

	<!-- SECCION DONDE SE ENCUENTRAN LOS FORMULARIOS PARA CREAR LAS COOKIES -->
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">
			<div class="row">
				<div class="col-lg-4 col-md-12 col-sm-12 vehiculosForm">
					<h4>SUV</h4>
					<img src="http://localhost/img/DWES/p1/urus.jpg" height="80%"
						width="100%">
					<form method="POST" action="suv.jsp">
						<input type="hidden" name="suv" value="suv"> <input
							type="submit" value="Saber Más" class="btnCookies">
					</form>

				</div>
				<div class="col-lg-4 col-md-12 col-sm-12 vehiculosForm">
					<h4>SPORT</h4>
					<img src="http://localhost/img/DWES/p1/mclaren.jpg" height="80%"
						width="100%">
					<form method="POST" action="sport.jsp">
						<input type="hidden" name="sport" value="sport"> <input
							type="submit" value="Saber Más" class="btnCookies">
					</form>
				</div>
				<div class="col-lg-4 col-md-12 col-sm-12 vehiculosForm">
					<h4>MOTOS</h4>
					<img src="http://localhost/img/DWES/p1/moto.jpg" height="80%"
						width="100%">
					<form method="POST" action="moto.jsp">
						<input type="hidden" name="moto" value="moto"> <input
							type="submit" value="Saber Más" class="btnCookies">
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- SECCION MARCAS -->
	<div class="row" id=marcas>

		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca1.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca2.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1//marca3.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca4.png">
		</div>

		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca5.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca6.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca7.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca8.png">
		</div>

		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca9.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca10.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca11.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca12.png">
		</div>

		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca13.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca14.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca15.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-6 carta">
			<img src="http://localhost/img/DWES/p1/marca16.png">
		</div>
	</div>
	<!-- FOOTER -->
	<%@include file="includes/footer.jsp"%>
</body>

<script src="resources/js/modal.js"></script>
</html>