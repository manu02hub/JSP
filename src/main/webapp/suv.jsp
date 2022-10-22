<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<link rel="stylesheet" text="text/css" href="resources/css/footer.css" />
<link rel="stylesheet" text="text/css" href="resources/css/estilo2.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/responsive.css" />
<link rel="stylesheet" text="text/css"
	href="resources/css/navs/navIndex.css" />

<title>Insert title here</title>
</head>
<body>
	<%
	Cookie[] cookies = request.getCookies();
	// 2. Buscamos la cookie con el nombre que queremos
	// En este caso el nombre es "deporte_favorito".

	// 1. Recoger elemento del select
	String vehiculo = request.getParameter("suv");

	// 2. Creo la Cookie --> (clave, valor)
	// Ver API JEE Cookie.
	Cookie cookie = new Cookie("suv", vehiculo);

	// 3. Establecer la vida de la cookie.
	// Tener en cuenta que es en segundos
	//cookie.setMaxAge(60*60); // 1h
	cookie.setMaxAge(60); // 5seg

	// 4. Enviar la cookie
	response.addCookie(cookie);
	%>

	<%@include file="includes/navIndex.jsp"%>

	<div class="row blg" id="blg2">
		<div class="col-sm-6 col-md-6 col-lg-6">
			<img src="http://localhost/img/DWES/p1/suv3.jpg" width="702px"
				height="437px">
			<div class="contenedor">
				<strong>LA NUEVA GENERACION DE SUV 2022 IMPULSA LA NUEVA
					TECNOLOGIA</strong>
			</div>
		</div>
		<div class="col-sm-6 col-md-6 col-lg-6">
			<img src="http://localhost/img/DWES/p1/suv6.jpg" width="700px">
			<div class="contenedor">
				<strong>MAS SALVAJE QUE ANTES</strong>
			</div>
		</div>
	</div>

	<div class="row" id="blg1">
		<div class="col-lg-1 col-md-1 col-sm-1"></div>
		<div class="col-lg-10 col-md-10 col-sm-10 blg">
			<div>
				<img src="http://localhost/img/DWES/p1/suv1.jpg" width="800px">
			</div>
			<div class="contenedor">
				<strong>LA NUEVA BESTIA EN EL MUNDO DEL MOTOR</strong> <strong>HA
					LLEGADO</strong>
			</div>
		</div>
		<div class="col-lg-1 col-md-1 col-sm-1"></div>
	</div>
	<div class="row blg" id="blg5">
		<div class="col-sm-6 col-md-6 col-lg-6" id="blg4">
			<div id="textoNorris">
				<strong>Loubet se une a M-Sport Ford para la temporada 2022
					del WRC</strong>
				<p>Lando Norris, piloto de F1 nacido el 13 de noviembre de 1999
					en Bristol, Reino Unido, es campeon del mundo de Karting e hizo sus
					primeras apariciones en circuitos mas alla del Karting en 2014, en
					la que es la escuela britanica por excelencia, la Ginetta Junior,
					campeonato que suele garantizar un gran futuro a sus participantes
					mas exitosos, aunque no precisamente en Formulas.</p>
				<p>El buen hacer del menudo piloto britanico, con cuatro
					victorias, le llevo a dar el salto a la Formula 4 britanica, bajo
					el amparo del equipo que le ha acompanado durante sus anos de
					formacion; Carlin. Lando se proclamo campeon en su primer ano,
					2015, y sus actuaciones le valieron cameos en los campeonatos
					aleman e italiano, donde causo buena impresion.</p>
			</div>


		</div>
		<div class="col-sm-6 col-md-6 col-lg-6">
			<img src="http://localhost/img/DWES/p1/suv4.jpg" width="700px">
			<div class="contenedor" id="blg3">
				<strong>NORRIS</strong>
			</div>
		</div>
	</div>


	<%@include file="includes/footer.jsp"%>

</body>
</html>