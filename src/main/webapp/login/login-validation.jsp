<%@page import="imf.garaje.models.Usuario"%>
<%

//Si existe usuario loguado puede entrar
	if(request.getSession().getAttribute("usuario")!= null){
		
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		
		//out.println(request.getSession().getAttribute("usuario").getEmail());
	}else{
		//Redirigir al login para introducir credenciales
		response.sendRedirect("AuthController?action=index");
		
	}
%>