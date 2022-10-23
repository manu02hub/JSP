package imf.garaje.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import imf.garaje.models.Modelo;
import imf.garaje.modelsDAO.ModeloDAO;

/**
 * Servlet implementation class ModeloController
 */
public class ModeloController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Distingue entre las vistas a las que tengo que ridereccionar
	String acceso;
	// Variable que recibo por url y que me enlaza con el metodo o vista
	// correspondiente
	String action;

	int id;
	int anno;
	String nombre;
	String foto;

	String filtro = null;

	// Rutas
	String index = "modelo/index.jsp";
	String create = "modelo/create.jsp";
	String edit = "modelo/update.jsp";

	Modelo modelo;
	ModeloDAO modeloDAO = new ModeloDAO();
	ArrayList<Modelo> listadoModelo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModeloController() {
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

			// recojo todos los modelos
			listadoModelo = modeloDAO.getModelos();

			// Mandamos este array a la siguiente vista
			request.setAttribute("mode", listadoModelo);
			acceso = index;
			break;

		case "buscadorCliente":

			// Caso no funcional
			filtro = request.getParameter("buscadorCliente");

			// listadoMarcas = marcaDAO.buscarMarca(request.getParameter("buscador"));

			request.setAttribute("mol", listadoModelo);
			acceso = index;
			break;

		case "create":
			acceso = create;
			break;

		case "edit":
			// Recojo el ID por URL
			id = Integer.parseInt(request.getParameter("id"));

			// Envio ID recogido por URL
			request.setAttribute("mod", modeloDAO.find(id));

			acceso = edit;
			break;

		case "delete":

			// En caso de eliminar recoemos id y llamamos al método correspondiente
			id = Integer.parseInt(request.getParameter("id"));
			modeloDAO.eliminarModelo(id);

			// recojo todos los modelos
			listadoModelo = modeloDAO.getModelos();

			// Mandamos este array a la siguiente vista
			request.setAttribute("mode", listadoModelo);

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

			// recogemos los datos después de rellear el formulario
			nombre = request.getParameter("nombre_modelo");
			foto = request.getParameter("http://localhost/img/DWES/p1/" + foto);
			anno = Integer.parseInt(request.getParameter("anno"));

			// Creamos un nuevo modelo con estos datos
			modelo = new Modelo();
			modelo.setFoto_modelo(foto);
			modelo.setNombre_modelo(nombre);
			modelo.setAnno(anno);

			modeloDAO.crearModelo(modelo);

			// recojo todos los modelos
			listadoModelo = modeloDAO.getModelos();

			// Mandamos este array a la siguiente vista
			request.setAttribute("mode", listadoModelo);
			acceso = index;

			break;

		case "update":

			// recogemos de nuevo los datos pero esta vez obtenemos el id para actualizar
			// datos
			id = Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre_modelo");
			foto = request.getParameter("foto_modelo");
			anno = Integer.parseInt(request.getParameter("anno"));

			modelo = new Modelo();
			modelo.setId_modelo(id);
			modelo.setFoto_modelo("http://localhost/img/DWES/p1/" + foto);
			modelo.setNombre_modelo(nombre);
			modelo.setAnno(anno);

			modeloDAO.actualizarModelo(modelo);

			// recojo todos los modelos
			listadoModelo = modeloDAO.getModelos();

			// Mandamos este array a la siguiente vista
			request.setAttribute("mode", listadoModelo);

			acceso = index;
			break;

		}

		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}

}
