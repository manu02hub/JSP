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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		acceso = "";
		action = request.getParameter("action"); // valor que recojo por url
		
		switch (action) {
		case "index":

			listadoMarcas = marcaDAO.getMarcas();

			request.setAttribute("mar", listadoMarcas);
			acceso = index;
			break;

		case "buscadorCliente":

			filtro = request.getParameter("buscadorCliente");

			//listadoMarcas = marcaDAO.buscarMarca(request.getParameter("buscador"));

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
			id = Integer.parseInt(request.getParameter("id"));
			marcaDAO.eliminarMarca(id);

			acceso = index;
			break;

		}
		
		// Lanzar la vista en funcion del action recibido
				RequestDispatcher vista = request.getRequestDispatcher(acceso);
				vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// doGet(request, response);
				acceso = "";
				action = request.getParameter("action"); // valor que recojo por url

				switch (action) {
				case "create":
					nombre = request.getParameter("nombre_marca");
					foto = request.getParameter("foto_marca");

					marca = new Marca();
					marca.setFoto_marca("http://localhost/img/DWES/p1/"+foto);
					marca.setNombre_marca(nombre);
				
					System.out.println(marca.toString());

					marcaDAO.crearMarca(marca);
					acceso = index;

					break;

				case "update":
					id = Integer.parseInt(request.getParameter("id"));
					nombre = request.getParameter("nombre_marca");
					foto = request.getParameter("foto");

					marca = new Marca();
					marca.setId_marca(id);
					marca.setNombre_marca(nombre);
					marca.setFoto_marca("http://localhost/img/DWES/p1/"+foto);
					

					marcaDAO.actualizarMarca(marca);

					acceso = index;
					break;

				}

				// Lanzar la vista en funcion del action recibido
				// Lanzar la vista en funcion del action recibido
				RequestDispatcher vista = request.getRequestDispatcher(acceso);
				vista.forward(request, response);

			}

}
