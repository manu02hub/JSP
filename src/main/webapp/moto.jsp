<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" text="text/css" href="resources/css/footer.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css" href="resources/css/estilo4.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/navs/navIndex.css" />

<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/jquery-jvectormap-2.0.5.css">
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/jquery-jvectormap-2.0.5.css">
<script type="text/javascript"
	src="resources/js/jquery-jvectormap-2.0.5.min.js"></script>
<script type="text/javascript"
	src="resources/js/jquery-jvectormap-world-mill.js"></script>
<script type="text/javascript"
	src="resources/js/jquery-jvectormap-es-mill.js"></script>
<title>Insert title here</title>
</head>
<body>

	<%
	// 1. Recoger elemento del select
	String vehiculo = request.getParameter("moto");

	// 2. Creo la Cookie --> (clave, valor)
	// Ver API JEE Cookie.
	Cookie cookie = new Cookie("moto", vehiculo);

	// 3. Establecer la vida de la cookie.
	// Tener en cuenta que es en segundos
	//cookie.setMaxAge(60*60); // 1h
	cookie.setMaxAge(60); // 5seg

	// 4. Enviar la cookie
	response.addCookie(cookie);
	%>

	<%@include file="includes/navIndex.jsp"%>
	
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">
			<div class="row">
				<div class="col-lg-4 col-md-4 col-sm-4 vehiculosForm">
					<img src="http://localhost/img/DWES/p1/moto1.jpg" width="500px"
						width="480px">
					<h4>ULTRA LIMITED</h4>
					<p>La Ultra Limited 2022 es la experiencia de viaje más
						completa, ofrece un estilo atrevido y unas características de
						primera clase para viajar, sin comprometer el comportamiento
						dinámico.</p>

				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 vehiculosForm">
					<img src="http://localhost/img/DWES/p1/moto2.jpg" width="500px"
						width="480px">
					<h4>STREET BOB 114</h4>
					<p>Una dinámica y desnuda bobber teñida de negro. 114 2022 es
						la base de altas prestaciones perfecta para la personalización.</p>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4 vehiculosForm">
					<img src="http://localhost/img/DWES/p1/moto3.jpg" width="500px"
						width="480px">
					<h4>NIGTHSTER</h4>
					<p>Es una máquina nacida de un icono de ayer y evolucionada para los pilotos de hoy. Una moto que combina la clásica silueta Sportster con toda la potencia del motor Revolution</p>
				</div>
			</div>
		</div>
	</div>

	<div class="row" id="mapa">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<div id="my-map" style="width: 100%; height: 500px;"></div>
		</div>
	</div>


	<%@include file="includes/footer.jsp"%>

	<script src="resources/js/map.js"></script>

</body>
</html>