package imf.garaje.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.Url;

import imf.garaje.models.Usuario;
import imf.garaje.modelsDAO.UsuarioDAO;

/**
 * Servlet implementation class AuthController
 */
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String action, acceso;

	Usuario usuario;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	String email, password;

	String index = "index.jsp";
	String login = "login/login.jsp";
	String home = "usuario/index.jsp";
	String indexAdmin = "cliente/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		action = request.getParameter("action");

		switch (action) {
		case "login":
			acceso = login;

			break;

		case "home":
			acceso = home;

			break;

		case "logout":
			request.getSession().removeAttribute("usuario");
			acceso = index;
			break;

		default:
			break;
		}

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

		action = request.getParameter("action");

		switch (action) {
		case "login":
			/*
			 * Realizo el login de mi aplicacion
			 */

			/* COMENTARIO */
			email = request.getParameter("email");
			password = request.getParameter("password");
			System.out.println(password);
			System.out.println(getMD5(password));
			if (usuarioDAO.validate(email, getMD5(password))) {
				// Correcto, usuario existe con email y password correctos
				/* Debo guardar en sesion mi objeto Usuario con los datos correspondientes */
				usuario = usuarioDAO.getUsuario(email, getMD5(password));
				request.getSession().setAttribute("usuario", usuario);

				ArrayList<Usuario> usuarios = usuarioDAO.all();
				request.getSession().setAttribute("usuarios", usuarios);
				acceso = home;

			} else {
				acceso = index;
				// Al ser un error, puedo enviar un mensaje con setAttribute
			}
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
