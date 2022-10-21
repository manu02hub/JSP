<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/login.css" />
<link rel="stylesheet" text="text/css" href="resources/css/estilo.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/navs/navIndex.css" />
<script src="resources/js/jquery-3.6.0.min.js"></script>
<title>MANUS GARAGE</title>
</head>
<body>

	<%@include file="includes/navIndex.jsp"%>

	<%
	String favorito = null;

	// 1. Leer la cookie del navegador
	Cookie[] cookies = request.getCookies();

	// 2. Buscamos la cookie con el nombre que queremos
	// En este caso el nombre es "deporte_favorito".

	if (cookies != null) {
		for (Cookie cookie_temporal : cookies) {
			if ("vehiculo".equals(cookie_temporal.getName())) {
		favorito = cookie_temporal.getValue();
		out.print("UBICACION: " + cookie_temporal.getPath());
		out.print("UBICACION: " + cookie_temporal.getName());
		out.print("UBICACION: " + cookie_temporal.getValue());
		out.print("FAVORITO: " + favorito);

		if (favorito.equals("suv")) {
		%>
	
		<div class="row" id="contImgFondo"
			background=url(http://localhost/img/DWES/p1/urus.jpg>
			<div class="col-lg-12 col-md-12 col-sm-12" id="textIntro">
				<h2>SUV EN WRAPPING & DETAILING</h2>
			</div>
		</div>
		<%
		} else if (favorito.equals("sport")) {
		%>
	
		<div class="row" id="contImgFondo"
			background="url(http://localhost/img/DWES/p1/mclaren.jpg)">
			<div class="col-lg-12 col-md-12 col-sm-12" id="textIntro">
				<h2>SPORT EN WRAPPING & DETAILING</h2>
			</div>
		</div>
		<%
		} else {
		%>
	
		<div class="row" id="contImgFondo"
			background="url(http://localhost/img/DWES/p1/moto.jpg)">
			<div class="col-lg-12 col-md-12 col-sm-12" id="textIntro">
				<h2>MOTO EN WRAPPING & DETAILING</h2>
			</div>
		</div>
		<%
		}

	}
	}
	}else {
		%>
		<div class="row" id="contImgFondo">
			<div class="col-lg-12 col-md-12 col-sm-12" id="textIntro">
				<h2>ESPECIALISTAS EN WRAPPING & DETAILING</h2>
			</div>
		</div>
		<%
		}
	%>



	<div class="row">
		<div class="col-lg-4 col-md-4 col-sm-4" id="Snosotros">
			<h3>SOBRE NOSOTROS</h3>
			<p>Más de 10 años de experiencia en vinilado y detallado de
				vehículos. Desde cambiar el color completo o de alguna parte hasta
				conseguir dejar tu coche o moto como nuevo a través de limpiezas
				integrales, pulidos y tratamientos cerámicos. En Parson Garage nos
				adaptamos a tus necesidades para renovar, personalizar y cuidar tu
				vehículo con la garantía y experiencia que nos avala.</p>
		</div>
		<div class="col-lg-8 col-md-8 col-sm-8" id="trabajo">
			<div class="row" id="cosas">
				<div class="col-lg-4 col-md-4 col-sm-4 informacion">
					<h4>WRAPPING</h4>
					<p>Transforma el aspecto de tu vehículo con nuestro servicio de
						wrapping o vinilado. Más de 200 colores (satinados, brillos, mates
						y cromados) para personalizar partes o la totalidad de tu coche o
						moto y darle un aspecto exclusivo y duradero</p>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 informacion">
					<h4>DETALING</h4>
					<p>Preserva y restaura la apariencia de tu vehículo con
						nuestros servicios de limpieza integral interior y exterior,
						pulido de carrocería y tratamientos cerámicos. Tu vehículo lucirá
						mejor que el primer día con resultados dignos de exposición</p>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 informacion">
					<h4>PRO</h4>
					<p>Ofrecemos toda una gama de servicios profesionales de
						vinilado y rotulado de flotas, ediciones limitadas para
						concesionarios, limpieza integral, detallado y mantenimiento a
						domicilio etc.</p>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12" id="trabajo">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-4 informacion">
					<h4>SUV</h4>
					<form method="POST" action="suv.jsp">
						<input type="hidden" name="suv"> <input type="submit"
							value="Saber Más">
					</form>

				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 informacion">
					<h4>SPORT</h4>
					<form method="POST" action="sport.jsp">
						<input type="hidden" name="sport"> <input type="submit"
							value="Saber Más">
					</form>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 informacion">
					<h4>MOTOS</h4>
					<form method="POST" action="moto.jsp">
						<input type="hidden" name="moto"> <input type="submit"
							value="Saber Más">
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="row" id=marcas>

		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca1.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca2.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1//marca3.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca4.png">
		</div>

		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca5.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca6.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca7.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca8.png">
		</div>

		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca9.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca10.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca11.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca12.png">
		</div>

		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca13.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca14.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca15.png">
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 carta">
			<img src="http://localhost/img/DWES/p1/marca16.png">
		</div>
	</div>
</body>

<script src="resources/js/modal.js"></script>
</html>