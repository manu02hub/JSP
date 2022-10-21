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



public class ClienteDAO implements ClienteBd{

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
		String sql = "INSERT INTO cliente (foto,nombre, email) VALUES ('" + cliente.getFoto() + "', '"
				+ cliente.getNombre() + "', '" + cliente.getEmail() + "')";
		
		System.out.println(sql);
		
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	@Override
	public boolean eliminarcliente(int id) {

		String sql = "DELETE FROM cliente WHERE id_cliente = " + id;
		System.out.println(sql);

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

	@Override
	public Cliente actualizarcliente(Cliente cliente) {

		String sql = "UPDATE cliente SET nombre = '" + cliente.getNombre() + "', email = '" + cliente.getEmail()
				+ "' WHERE id_cliente=" + cliente.getId();
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}
	
	@Override
	public Cliente find(int id) {
		String sql = "SELECT * FROM cliente WHERE id_cliente = " + id;
		System.out.println(sql);
		
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cliente.setId(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public ArrayList<Cliente> buscarcliente(String correo) {
		
		String sql = "SELECT* FROM cliente WHERE email = " + correo;
		
		listado = new ArrayList<Cliente>();

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

		return listado;
	}

	@Override
	public ArrayList<Cliente> getclientes() {


		listado = new ArrayList<Cliente>();

		String sql = "SELECT* FROM cliente";

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

				
				listado.add(new Cliente(id, foto, nombre, correo));
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listado;
	}

}
