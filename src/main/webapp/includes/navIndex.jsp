<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nav index</title>

</head>
<body>


	<div class="row" id="cabecera">
		<div class="col-lg-3 col-md-3 col-sm-3">
			<header>
				<img src="http://localhost/img/DWES/p1/AUTOMOTIVE2.png"
					id="automotive" />
			</header>
		</div>
		<div class="col-lg-9 col-md-9 col-sm-9">
			<nav>
				<ul>
					<li><a href="#">HOME</a></li>
					<li><a href="#">SUV</a></li>
					<li><a href="ClienteController?action=index" type="button">SPORT</a></li>
					<%
					if (request.getSession().getAttribute("usuario") == null) {
					%>
					<li><a href="ClienteController?action=index">LOGIN</a></li>

					<%-- <%@include file="../login/login.jsp"%> --%>
					<%
					} else {
					%>
					<li><a href="#" id="show-login">LOGIN</a></li>
					<!-- <li><a href="AuthController?action=home">LOGIN</a></li> -->
					<%
					}
					%>
				</ul>
			</nav>
		</div>
	</div>

</body>
</html>