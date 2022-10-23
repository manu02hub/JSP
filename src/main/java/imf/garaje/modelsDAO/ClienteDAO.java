package imf.garaje.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imf.garaje.config.Conexion;
import imf.garaje.interfaces.ClienteBd;
import imf.garaje.models.Cliente;

public class ClienteDAO implements ClienteBd {

	Conexion conexion = new Conexion();
	Connection conn;
	PreparedStatement ps;
	Statement statement;
	ResultSet rs;

	int id;
	String foto;
	String nombre;
	String correo;

	Cliente cliente = new Cliente();
	ArrayList<Cliente> listado = new ArrayList<Cliente>();

	@Override
	public Cliente crearcliente(Cliente cliente) {
		// Sentencia sql para crear un cliente
		String sql = "INSERT INTO cliente (foto,nombre, email) VALUES ('" + cliente.getFoto() + "', '"
				+ cliente.getNombre() + "', '" + cliente.getEmail() + "')";

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
		return cliente;
	}

	@Override
	public boolean eliminarcliente(int id) {

		// Sentencia sql para eliminar un cliente de la tabla
		String sql = "DELETE FROM cliente WHERE id_cliente = " + id;

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

		// Retorno true si se realizo la sentencia
		return true;
	}

	@Override
	public Cliente actualizarcliente(Cliente cliente) {

		// Sentencia sql para actualizar un cliente de la tabla
		String sql = "UPDATE cliente SET nombre = '" + cliente.getNombre() + "', email = '" + cliente.getEmail()
				+ "', foto = '" + cliente.getFoto() + "' WHERE id_cliente=" + cliente.getId();

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
		return cliente;
	}

	@Override
	public Cliente find(int id) {

		// Sentencia sql para encontrar un cliente de la tabla por id
		String sql = "SELECT * FROM cliente WHERE id_cliente = " + id;

		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				cliente.setId(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setEmail(rs.getString("email"));
				cliente.setFoto(rs.getString("foto"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();

		// retono el cliente
		return cliente;
	}

	// Método no funcional
	@Override
	public ArrayList<Cliente> buscarcliente(String correo) {

		// Sentencia sql para buscar un cliente de la tabla por correo
		String sql = "SELECT* FROM cliente WHERE email = " + correo;

		listado = new ArrayList<Cliente>();

		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				id = rs.getInt("id_cliente");
				foto = rs.getString("foto");
				nombre = rs.getString("nombre");
				correo = rs.getString("email");

				listado.add(new Cliente(id, foto, nombre, correo));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();

		// retorno array
		return listado;
	}

	@Override
	public ArrayList<Cliente> getclientes() {

		listado = new ArrayList<Cliente>();

		// Sentencia sql para conseguir todos los datos de la tabla
		String sql = "SELECT* FROM cliente";

		// Creo conexion y realizo sentencia sql
		try {

			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("ESO");

			while (rs.next()) {
				id = rs.getInt("id_cliente");
				foto = rs.getString("foto");
				nombre = rs.getString("nombre");
				correo = rs.getString("email");

				// añado a array
				listado.add(new Cliente(id, foto, nombre, correo));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();

		// retorno array
		return listado;
	}

}
