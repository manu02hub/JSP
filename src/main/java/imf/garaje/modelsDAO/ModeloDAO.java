/**
 * 
 */
package imf.garaje.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imf.garaje.config.Conexion;
import imf.garaje.interfaces.ModeloBd;
import imf.garaje.models.Marca;
import imf.garaje.models.Modelo;;

/**
 * @author manue
 *
 */
public class ModeloDAO implements ModeloBd {

	Conexion conexion = new Conexion();
	Connection conn;
	PreparedStatement ps;
	Statement statement;
	ResultSet rs;

	int id;
	String foto;
	String nombre;
	int anno;

	Modelo modelo = new Modelo();
	ArrayList<Modelo> listado;

	@Override
	public Modelo crearModelo(Modelo modelo) {

		// Sentencia sql para crear un modelo
		String sql = "INSERT INTO modelo (foto_modelo,nombre_modelo,anno) VALUES ('" + modelo.getFoto_modelo() + "', '"
				+ modelo.getNombre_modelo() + "', '" + modelo.getAnno() + "')";

		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Cierro conexion
		conn = conexion.desconectar();
		
		// retorno modelo
		return modelo;

	}

	@Override
	public boolean eliminarModelo(int id) {

		// Sentencia sql para eliminar un modelo por id
		String sql = "DELETE FROM modelo WHERE id_modelo = " + id;
		
		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		
		// retorno true en caso de que se haya ejecutado bien la sentencia sql
		return true;
	}

	@Override
	public Modelo actualizarModelo(Modelo modelo) {
		
		// Sentencia sql para actualizar  un modelo de la bd
		String sql = "UPDATE modelo SET nombre_modelo = '" + modelo.getNombre_modelo() + "',anno = '" + modelo.getAnno()
				+ "',foto_modelo = '" + modelo.getFoto_modelo() + "' WHERE id_modelo=" + modelo.getId_modelo();
		
		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		// retorno objeto modelo
		return modelo;
	}

	//Metodo no funcional
	@Override
	public Modelo buscarModelo(int id) {
		
		// Sentencia sql para buscar un modelo por id
		String sql = "SELECT* FROM modelo WHERE id_modelo = " + id;
		
		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				modelo.setId_modelo(id);
				modelo.setFoto_modelo(rs.getString("nombre"));
				modelo.setNombre_modelo(rs.getString("nombre"));
				modelo.setAnno(rs.getInt("email"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		
		// retorno modelo
		return modelo;
	}

	@Override
	public Modelo find(int id) {
		// Sentencia sql para para buscar un modelo por id
		String sql = "SELECT * FROM modelo WHERE id_modelo = " + id;

		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				modelo.setId_modelo(rs.getInt("id_modelo"));
				modelo.setNombre_modelo(rs.getString("nombre_modelo"));
				modelo.setAnno(rs.getInt("anno"));
				modelo.setFoto_modelo(rs.getString("foto_modelo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		// retorno modelo
		return modelo;
	}

	@Override
	public ArrayList<Modelo> getModelos() {

		listado = new ArrayList<Modelo>();
		
		// Sentencia sql para obtener todos los datos de la tabla modelo
		String sql = "SELECT* FROM modelo";
		
		// Creo conexion y realizo sentencia sql
		try {

			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id_modelo");
				foto = rs.getString("foto_modelo");
				nombre = rs.getString("nombre_modelo");
				anno = rs.getInt("anno");

				listado.add(new Modelo(id, foto, nombre, anno));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		// retorno array modelo
		return listado;
	}

}
