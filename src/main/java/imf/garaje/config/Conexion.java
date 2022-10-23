/**
 * 
 */
package imf.garaje.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author manue
 *
 */
public class Conexion {
	Connection conection;

	public Conexion() {
		try {

			// nombre de la clase de controlador y los parámetros de controlador que se van
			// a utilizar al conectarse a una base de datos.
			Class.forName("com.mysql.jdbc.Driver");
			// conection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto2DAW",
			// "root", "");
		} catch (ClassNotFoundException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
	}

	// Metodo para conectarse a la bd
	public Connection getConnection() throws SQLException {
		// Creo la conexion, sin esta linea aquí al cerrar conexion e intentar volver a
		// conectarse la conexion es nula y da error
		conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto2DAW", "root", "");
		return conection;
	}

	// Cerrar conexion
	public Connection desconectar() {
		conection = null;
		return conection;
	}
}
