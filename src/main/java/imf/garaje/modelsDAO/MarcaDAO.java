package imf.garaje.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imf.garaje.config.Conexion;
import imf.garaje.interfaces.MarcaBd;
import imf.garaje.models.Cliente;
import imf.garaje.models.Marca;

public class MarcaDAO implements MarcaBd {

	Conexion conexion = new Conexion();
	Connection conn;
	PreparedStatement ps;
	Statement statement;
	ResultSet rs;

	int id;
	String foto;
	String nombre;

	Marca marca = new Marca();
	ArrayList<Marca> listado;

	@Override
	public Marca crearMarca(Marca marca) {
		// Sentencia sql para crear una marca
		String sql = "INSERT INTO marca (foto_marca,nombre_marca) VALUES ('" + marca.getFoto_marca() + "', '"
				+ marca.getNombre_marca() + "')";

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

		// retorno cliente
		return marca;
	}

	@Override
	public boolean eliminarMarca(int id) {

		// Sentencia sql para eliminar una marca
		String sql = "DELETE FROM marca WHERE id_marca = " + id;

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

		// retorno cliente
		return true;
	}

	@Override
	public Marca actualizarMarca(Marca marca) {
		// Sentencia sql para obtener un actualizar datos de una marca
		String sql = "UPDATE marca SET nombre_marca = '" + marca.getNombre_marca() + "', foto_marca = '"
				+ marca.getFoto_marca() + "' WHERE id_marca=" + marca.getId_marca();

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

		// retorno cliente
		return marca;
	}

	// Metodo no funcional
	@Override
	public Marca buscarMarca(int id) {
		// Sentencia sql para obtener un marca por id
		String sql = "SELECT* FROM marca WHERE id = " + id;

		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				marca.setId_marca(id);
				marca.setFoto_marca(rs.getString("nombre"));
				marca.setNombre_marca(rs.getString("nombre"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();

		// retorno cliente
		return marca;
	}

	@Override
	public Marca find(int id) {
		// Sentencia sql para obtener una marca por id
		String sql = "SELECT * FROM marca WHERE id_marca = " + id;

		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				marca.setId_marca(rs.getInt("id_marca"));
				marca.setNombre_marca(rs.getString("nombre_marca"));
				marca.setFoto_marca(rs.getString("foto_marca"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();

		// retorno cliente
		return marca;
	}

	@Override
	public ArrayList<Marca> getMarcas() {

		listado = new ArrayList<Marca>();

		// Sentencia sql para crear obtener los datos de la tabla marca
		String sql = "SELECT* FROM marca";

		// Creo conexion y realizo sentencia sql
		try {

			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id_marca");
				foto = rs.getString("foto_marca");
				nombre = rs.getString("nombre_marca");

				listado.add(new Marca(id, foto, nombre));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();

		// retorno cliente
		return listado;
	}
}
