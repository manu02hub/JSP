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
import imf.garaje.models.Marca;
import imf.garaje.models.Modelo;
;

/**
 * @author manue
 *
 */
public class ModeloDAO {
	
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
	
	public Modelo crearModelo(Modelo modelo) {
		
		String sql = "INSERT INTO modelo (foto_modelo,nombre_modelo,anno) VALUES ('" + modelo.getFoto_modelo() + "', '"
				+ modelo.getNombre_modelo() + "', '"+ modelo.getAnno() + "')";
		
		System.out.println(sql);
		
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modelo;
		
		
	}

	public boolean eliminarModelo(int id) {

		String sql = "DELETE FROM modelo WHERE id_modelo = " + id;

		try {
			conn = conexion.getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public Modelo actualizarModelo(Modelo modelo) {
		String sql = "UPDATE modelo SET nombre_modelo = '" + modelo.getNombre_modelo()+ "',anno = '" + modelo.getAnno() +"' WHERE id_modelo=" + modelo.getId_modelo();
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modelo;
	}

	public Modelo buscarModelo(int id) {
		String sql = "SELECT* FROM modelo WHERE id_modelo = " + id;

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

		return modelo;
	}
	
	public Modelo find(int id) {
		String sql = "SELECT * FROM modelo WHERE id_modelo = " + id;
		System.out.println(sql);

		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				modelo.setId_modelo(rs.getInt("id_modelo"));
				modelo.setNombre_modelo(rs.getString("nombre_modelo"));
				modelo.setAnno(rs.getInt("anno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelo;
	}

	public ArrayList<Modelo> getModelos() {
		
		
		listado = new ArrayList<Modelo>();
		
		String sql = "SELECT* FROM modelo";

		try {
			
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("id_modelo");
				foto = rs.getString("foto_modelo");
				nombre = rs.getString("nombre_modelo");
				anno = rs.getInt("anno");
				
				listado.add(new Modelo(id,foto,nombre,anno));				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listado;
	}

}
