package imf.garaje.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import imf.garaje.models.Marca;
import imf.garaje.modelsDAO.MarcaDAO;

/**
 * Servlet implementation class MarcaController
 */
public class MarcaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Distingue entre las vistas a las que tengo que ridereccionar
	String acceso;
	// Variable que recibo por url y que me enlaza con el metodo o vista
	// correspondiente
	String action;
	String filtro = null;

	int id;
	String nombre;
	String foto;

	// Rutas
	String index = "marca/index.jsp";
	String create = "marca/create.jsp";
	String edit = "marca/update.jsp";

	Marca marca;
	MarcaDAO marcaDAO = new MarcaDAO();
	ArrayList<Marca> listadoMarcas;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarcaController() {
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

			// recojo todos las marcas
			listadoMarcas = marcaDAO.getMarcas();

			// Mandamos este array a la siguiente vista
			request.setAttribute("mar", listadoMarcas);
			acceso = index;
			break;

		case "buscadorCliente":

			// No funcional
			filtro = request.getParameter("buscadorCliente");

			// listadoMarcas = marcaDAO.buscarMarca(request.getParameter("buscador"));

			request.setAttribute("mar", listadoMarcas);
			acceso = index;
			break;

		case "create":
			acceso = create;
			break;

		case "edit":
			// Recojo el ID por URL
			id = Integer.parseInt(request.getParameter("id"));

			// Envio ID recogido por URL
			request.setAttribute("mar", marcaDAO.find(id));

			acceso = edit;
			break;

		case "delete":

			// En caso de eliminar recoemos id y llamamos al método correspondiente
			id = Integer.parseInt(request.getParameter("id"));
			marcaDAO.eliminarMarca(id);

			listadoMarcas = marcaDAO.getMarcas();

			// Mandamos este array a la siguiente vista
			request.setAttribute("mar", listadoMarcas);

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
		// doGet(request, response);
		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url

		switch (action) {
		case "create":

			// recogemos los datos después de rellear el formulario
			nombre = request.getParameter("nombre_marca");
			foto = request.getParameter("foto_marca");

			// Creamos un nuevo cliente con estos datos
			marca = new Marca();
			marca.setFoto_marca("http://localhost/img/DWES/p1/" + foto);
			marca.setNombre_marca(nombre);

			marcaDAO.crearMarca(marca);

			listadoMarcas = marcaDAO.getMarcas();

			// Mandamos este array a la siguiente vista
			request.setAttribute("mar", listadoMarcas);
			acceso = index;

			break;

		case "update":

			// recogemos de nuevo los datos pero esta vez obtenemos el id para actualizar
			// datos
			id = Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre_marca");
			foto = request.getParameter("foto");

			marca = new Marca();
			marca.setId_marca(id);
			marca.setNombre_marca(nombre);
			marca.setFoto_marca("http://localhost/img/DWES/p1/" + foto);

			marcaDAO.actualizarMarca(marca);

			listadoMarcas = marcaDAO.getMarcas();

			// Mandamos este array a la siguiente vista
			request.setAttribute("mar", listadoMarcas);

			acceso = index;
			break;

		}

		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}

}
