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

	//Rutas
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

		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url

		switch (action) {
		case "index":

			//recojo todos los clientes
			listadoClientes = clienteDAO.getclientes();

			//Mandamos este array a la siguiente vista
			request.setAttribute("cli", listadoClientes);
			acceso = index;
			break;

		case "buscadorCliente":

			//Metodo no funcional
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
			
			//En caso de eliminar recoemos id y llamamos al método correspondiente
			id = Integer.parseInt(request.getParameter("id"));
			clienteDAO.eliminarcliente(id);
			
			//recojo todos los clientes
			listadoClientes = clienteDAO.getclientes();
			//Mandamos este array a la siguiente vista
			request.setAttribute("cli", listadoClientes);

			acceso = index;
			break;

		}

		// Lanzar la vista en funcion del action recibido
		response.setHeader("Location", request.getContextPath() + "/" + acceso);
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
		
		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url

		
		switch (action) {
		case "create":
			
			//recogemos los datos después de rellear el formulario
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			foto = request.getParameter("fotocliente");

			//Creamos un nuevo cliente con estos datos
			cliente = new Cliente();
			cliente.setFoto("http://localhost/img/DWES/p1/"+foto);
			cliente.setNombre(nombre);
			cliente.setEmail(email);

			clienteDAO.crearcliente(cliente);
			//recojo todos los clientes
			listadoClientes = clienteDAO.getclientes();
			//Mandamos este array a la siguiente vista
			request.setAttribute("cli", listadoClientes);
			acceso = index;

			break;

		case "update":
			
			//recogemos de nuevo los datos pero esta vez  obtenemos el id para actualizar datos
			id = Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			foto = request.getParameter("fotocliente");

			cliente = new Cliente();
			cliente.setId(id);
			cliente.setNombre(nombre);
			cliente.setEmail(email);
			cliente.setFoto("http://localhost/img/DWES/p1/"+foto);

			clienteDAO.actualizarcliente(cliente);
			//recojo todos los clientes
			listadoClientes = clienteDAO.getclientes();
			//Mandamos este array a la siguiente vista
			request.setAttribute("cli", listadoClientes);

			acceso = index;
			break;

		}

		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}

}
