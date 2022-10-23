package imf.garaje.interfaces;

import java.util.ArrayList;

import imf.garaje.models.Usuario;

public interface UsuarioBd {
	
	//Metodos necesarios para mi clase Usuario DAO
	public Usuario save(Usuario usuario);
	public boolean delete(int id);
	public Usuario update(Usuario usuario);
	public Usuario find(int id);
	public ArrayList<Usuario> all();
	public boolean validate(String email, String password);
	public Usuario getUsuario(String email, String password);
}
