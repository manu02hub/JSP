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
	String vehiculo = request.getParameter("suv");

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

</body>
</html>