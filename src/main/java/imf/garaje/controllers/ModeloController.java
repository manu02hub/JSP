package imf.garaje.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url

		switch (action) {
		case "index":

			listadoModelo = modeloDAO.getModelos();

			request.setAttribute("mode", listadoModelo);
			acceso = index;
			break;

		case "buscadorCliente":

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
			id = Integer.parseInt(request.getParameter("id"));
			modeloDAO.eliminarModelo(id);

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
			nombre = request.getParameter("nombre_modelo");
			foto = request.getParameter("foto_modelo");
			anno = Integer.parseInt(request.getParameter("anno"));

			modelo = new Modelo();
			modelo.setFoto_modelo(foto);
			modelo.setNombre_modelo(nombre);
			modelo.setAnno(anno);

			modeloDAO.crearModelo(modelo);
			acceso = index;

			break;

		case "update":
			id = Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre_modelo");
			foto = request.getParameter("foto_modelo");
			anno = Integer.parseInt(request.getParameter("anno"));

			modelo = new Modelo();
			modelo.setId_modelo(id);
			modelo.setFoto_modelo(foto);
			modelo.setNombre_modelo(nombre);
			modelo.setAnno(anno);

			modeloDAO.actualizarModelo(modelo);

			acceso = index;
			break;

		}

		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}


}
