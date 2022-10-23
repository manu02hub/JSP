package imf.garaje.modelsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imf.garaje.config.Conexion;
import imf.garaje.interfaces.UsuarioBd;
import imf.garaje.models.Usuario;

public class UsuarioDAO implements UsuarioBd {

	Conexion conexion = new Conexion();

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Statement statement;

	Usuario usuario = new Usuario();
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	@Override
	public Usuario save(Usuario usuario) {

		// Sentencia sql para crear un usuario en la bd
		String sql = "INSERT INTO usuario (nombre,dni, email, password,img,rol) VALUES ('" + usuario.getNombre()
				+ "', '" + usuario.getDni() + "' ,  '" + usuario.getEmail() + "' ,  '" + usuario.getPassword()
				+ "' , 'http://localhost/img/DWES/p1/perfil.jpg', 'usuario')";

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
		// retorno usuario
		return usuario;
	}

	@Override
	public boolean delete(int id) {
		// Sentencia sql para eliminar un usuario de la bd
		String sql = "DELETE FROM usuario WHERE id = " + id;

		/// Creo conexion y realizo sentencia sql
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

		// retorno boolean si se realiza la sentencia
		return true;
	}

	@Override
	public Usuario update(Usuario usuario) {
		// Sentencia sql para actualizar un modelo
		String sql = "";
		// Si cambia la contraseña o no
		if (usuario.getPassword() != null) {
			sql = "UPDATE usuario SET nombre = '" + usuario.getNombre() + "', email = '" + usuario.getEmail()
					+ "', password = '" + usuario.getPassword() + "' WHERE id=" + usuario.getId();
		} else {
			sql = "UPDATE usuario SET nombre = '" + usuario.getNombre() + "', email = '" + usuario.getEmail()
					+ "' WHERE id=" + usuario.getId();
		}
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
		// retorno usuario
		return usuario;
	}

	@Override
	public Usuario find(int id) {
		// Sentencia sql para encontrar usuario en la bd
		String sql = "SELECT * FROM usuario WHERE id = " + id;

		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDni(rs.getString("dni"));
				usuario.setPassword(rs.getString("password"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		// retorno usuario
		return usuario;
	}

	@Override
	public ArrayList<Usuario> all() {
		// Sentencia sql para obtener todos los datos de la tabla usuario
		String sql = "SELECT * FROM usuario";

		usuarios = new ArrayList<Usuario>();
		/// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		// retorno usuarios
		return usuarios;
	}

	@Override
	public boolean validate(String email, String password) {
		// Sentencia sql para obtener usuario por correo y contraseña
		String sql = "SELECT * FROM usuario where email = '" + email + "' AND password = '" + password + "'";
		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {

				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		// retorno si se recibe dato ono
		return false;
	}

	@Override
	public Usuario getUsuario(String email, String password) {
		// Sentencia sql obtener usu
		String sql = "SELECT * FROM usuario where email = '" + email + "' AND password = '" + password + "'";
		// Creo conexion y realizo sentencia sql
		try {
			conn = conexion.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
				usuario.setImage(rs.getString("img"));
				usuario.setRole(rs.getString("rol"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cierro conexion
		conn = conexion.desconectar();
		// retorno usuario
		return usuario;
	}

}
