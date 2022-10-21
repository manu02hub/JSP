package imf.garaje.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

import imf.garaje.models.Usuario;
import imf.garaje.modelsDAO.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String acceso; // Variable que distingue entre las vistas a las que tengo que redireccionar
	String action; // Variable que recibo por URL y que me enlaza con el metodo/vista
					// correspondiente

	Usuario usuario;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	String nombre, email, password,dni;

	String index = "index.jsp";
	String indexUsu = "usuario/index.jsp";
	String create = "usuario/create.jsp";
	String edit = "usuario/edit.jsp";

	ArrayList<Usuario> usuarios;

	int id;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url

		switch (action) {
		case "index":
			usuarios = usuarioDAO.all();
			request.setAttribute("usu", usuarios);
			request.setAttribute("clase", "Somos de 2DAW");
			acceso = index;
			break;

		case "create":
			acceso = create;
			break;

		case "edit":
			// Recojo el ID por URL
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("usu", usuarioDAO.find(id));
			acceso = edit;
			break;

		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			usuarioDAO.delete(id);

			acceso = index;
			break;

		default:

			break;
		}
//		response.sendRedirect(acceso);
		response.setHeader("Location", request.getContextPath() + "/" + acceso);
		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url

		switch (action) {
		case "create":
			nombre = request.getParameter("nombre");
			dni =request.getParameter("dni");
			email = request.getParameter("email");
			password = request.getParameter("password");

			usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setEmail(email);
			usuario.setDni(dni);
			usuario.setPassword(getMD5(password));
			
			usuarioDAO.save(usuario);
			if (usuarioDAO.validate(email, getMD5(password))) {
				// Correcto, usuario existe con email y password correctos
				/* Debo guardar en sesion mi objeto Usuario con los datos correspondientes */
				request.getSession().setAttribute("usuario", usuarioDAO.getUsuario(email, getMD5(password)));
				ArrayList<Usuario> usuarios = usuarioDAO.all();
				request.getSession().setAttribute("usuarios", usuarios);
				acceso = indexUsu;
				
			} else {
				acceso = index;
				// Al ser un error, puedo enviar un mensaje con setAttribute
			}

			break;

		case "update":
			id = Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			password = request.getParameter("password");
			dni =request.getParameter("dni");

			usuario = new Usuario();
			usuario.setId(id);
			usuario.setNombre(nombre);
			usuario.setDni(dni);
			usuario.setEmail(email);

			if (password != null && password != "") {
				usuario.setPassword(getMD5(password));
			}
			// Si usuario no introduce password, no hay setPassword. Queda en null
			usuarioDAO.update(usuario);

			acceso = index;
			break;

		}
		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	public String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] encBytes = md.digest(input.getBytes());
			BigInteger numero = new BigInteger(1, encBytes);
			String encString = numero.toString(16);
			while (encString.length() < 32) {
				encString = "0" + encString;
			}
			return encString;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
