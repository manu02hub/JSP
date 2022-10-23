package imf.garaje.interfaces;

import java.util.ArrayList;

import imf.garaje.models.Cliente;

public interface ClienteBd {
	
	//Metodos necesarios para mi clase Cliente DAO
	public Cliente crearcliente(Cliente cliente);
	public boolean eliminarcliente(int id);
	public Cliente actualizarcliente(Cliente cliente);
	public Cliente find(int id);
	public ArrayList<Cliente> buscarcliente(String correo);
	public ArrayList<Cliente> getclientes();

}
