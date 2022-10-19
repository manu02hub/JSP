package imf.garaje.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import imf.garaje.models.Cliente;
import imf.garaje.modelsDAO.ClienteDAO;

/**
 * Servlet implementation class ClienteController
 */
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Distingue entre las vistas a las que tengo que ridereccionar
	String acceso;
	// Variable que recibo por url y que me enlaza con el metodo o vista
	// correspondiente
	String action;

	int id;
	String nombre;
	String email;
	String foto;

	String filtro = null;

	String index = "cliente/index.jsp";
	String create = "cliente/create.jsp";
	String edit = "cliente/update.jsp";

	Cliente cliente;
	ClienteDAO clienteDAO = new ClienteDAO();
	ArrayList<Cliente> listadoClientes;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url

		switch (action) {
		case "index":

			listadoClientes = clienteDAO.getclientes();

			request.setAttribute("cli", listadoClientes);
			acceso = index;
			break;

		case "buscadorCliente":

			filtro = request.getParameter("buscadorCliente");

			listadoClientes = clienteDAO.buscarcliente(request.getParameter("buscador"));

			request.setAttribute("cli", listadoClientes);
			acceso = index;
			break;

		case "create":
			acceso = create;
			break;

		case "edit":
			// Recojo el ID por URL
			id = Integer.parseInt(request.getParameter("id"));

			// Envio ID recogido por URL
			request.setAttribute("cli", clienteDAO.find(id));

			acceso = edit;
			break;

		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			clienteDAO.eliminarcliente(id);

			acceso = index;
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url

		switch (action) {
		case "create":
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			foto = request.getParameter("fotocliente");

			cliente = new Cliente();
			cliente.setFoto(foto);
			cliente.setNombre(nombre);
			cliente.setEmail(email);

			System.out.println(cliente.toString());

			clienteDAO.crearcliente(cliente);
			acceso = index;

			break;

		case "update":
			id = Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");

			cliente = new Cliente();
			cliente.setId(id);
			cliente.setNombre(nombre);
			cliente.setEmail(email);

			clienteDAO.actualizarcliente(cliente);

			acceso = index;
			break;

		}

		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}

}
