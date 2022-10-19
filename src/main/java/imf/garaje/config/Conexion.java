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
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto2DAW", "root", "");
		} catch (ClassNotFoundException | SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conection;
	}

	public Connection desconectar() {
		conection = null;
		return conection;
	}
}
